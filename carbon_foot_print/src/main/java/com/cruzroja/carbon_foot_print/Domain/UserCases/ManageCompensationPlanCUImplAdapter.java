/**
 * @file ManageCompensationPlanCUImplAdapter.java
 * @brief Implementación de la interfaz ManageCompensationPlanCUIntPort.
 */

 package com.cruzroja.carbon_foot_print.Domain.UserCases;

 import java.util.List;
 
 import com.cruzroja.carbon_foot_print.Application.Input.ManageCompensationPlanCUIntPort;
 import com.cruzroja.carbon_foot_print.Application.Output.ExceptionFormatterIntPort;
 import com.cruzroja.carbon_foot_print.Application.Output.ManageCompensationPlanGatewayIntPort;
 import com.cruzroja.carbon_foot_print.Domain.Models.CompensationPlan;
 
 /**
  * @class ManageCompensationPlanCUImplAdapter
  * @brief Implementación de los casos de uso para la gestión de planes de compensación.
  * 
  * Esta clase implementa la interfaz ManageCompensationPlanCUIntPort y proporciona
  * métodos para crear, actualizar, recuperar y gestionar planes de compensación.
  */
 public class ManageCompensationPlanCUImplAdapter implements ManageCompensationPlanCUIntPort {
 
     /** @brief Gateway para la gestión de planes de compensación. */
     private final ManageCompensationPlanGatewayIntPort gateway;
 
     /** @brief Formateador de excepciones. */
     private final ExceptionFormatterIntPort exceptionFormatter;
 
     /**
      * @brief Constructor de la clase.
      * 
      * @param gateway Gateway para la gestión de planes de compensación.
      * @param exceptionFormatter Formateador de excepciones.
      */
     public ManageCompensationPlanCUImplAdapter(ManageCompensationPlanGatewayIntPort gateway,
                                         ExceptionFormatterIntPort exceptionFormatter){
         this.gateway = gateway;
         this.exceptionFormatter = exceptionFormatter;
     }
 
     /**
      * @brief Recupera todos los planes de compensación.
      * 
      * Este método devuelve una lista de todos los planes de compensación registrados en el sistema.
      * 
      * @return Una lista de objetos de tipo CompensationPlan.
      * @throws NoDataException Si no se encuentran planes de compensación.
      */
     @Override
     public List<CompensationPlan> finAllCompensationPlan() {
         List<CompensationPlan> compensationPlans = this.gateway.findAll();
         if(compensationPlans.size() == 0){
             this.exceptionFormatter.returNoData("Not exists compensation plans");
         }
         return compensationPlans;
     }
 
     /**
      * @brief Guarda un nuevo plan de compensación.
      * 
      * Este método permite registrar un nuevo plan de compensación en el sistema.
      * 
      * @param compensationPlan El objeto CompensationPlan que se desea guardar.
      * @return El objeto CompensationPlan guardado.
      * @throws EntityExistsException Si el plan de compensación ya existe.
      * @throws BusinessRuleException Si alguna regla de negocio es violada.
      */
     @Override
     public CompensationPlan saveCompensationPlan(CompensationPlan compensationPlan) {
         CompensationPlan objPlan = null;
         if(this.gateway.existsByName(compensationPlan.getPlanName())){
             this.exceptionFormatter.returnResponseErrorEntityExists("Compensation plan with that name already exists in the System");
         }else{
             if(!compensationPlan.isValidDiscount()){
                 this.exceptionFormatter.returnResponseBusinessRuleViolated("Discount is not valid");
             }
             if(compensationPlan.hasDuplicateAction()){
                 this.exceptionFormatter.returnResponseBusinessRuleViolated("Compensation plan has actions duplicate");
             }
             if(!compensationPlan.isValidActions(this.gateway.findAllActions())){
                 this.exceptionFormatter.returnResponseBusinessRuleViolated("Compensation has actions that are not valid");
             }
             compensationPlan.calculatePrice();
             objPlan = this.gateway.save(compensationPlan);
         }
         return objPlan;
     }
 
     /**
      * @brief Actualiza un plan de compensación existente.
      * 
      * Este método permite actualizar los detalles de un plan de compensación ya existente.
      * 
      * @param compensationPlan El objeto CompensationPlan con los datos actualizados.
      * @return El objeto CompensationPlan actualizado.
      * @throws EntityNotFoundException Si el plan de compensación no se encuentra.
      * @throws BusinessRuleException Si alguna regla de negocio es violada.
      */
     @Override
     public CompensationPlan updateCompensationPlan(CompensationPlan compensationPlan) {
         CompensationPlan objPlan = null;
         if(!this.gateway.existsById(compensationPlan.getPlanId())){
             this.exceptionFormatter.returnResponseErrorEntityNotFound("Compensation plan with that id was not found");
         }else{
             CompensationPlan oldPlan = this.gateway.findById(compensationPlan.getPlanId());
             if(this.gateway.existsByName(compensationPlan.getPlanName())){
                 
                 if(!oldPlan.isPlanNameEqual(compensationPlan)){
                     this.exceptionFormatter.returnResponseErrorEntityNotFound("Compensation plan with that name already exists in the System");
                 }
             }else{
                 if(!compensationPlan.isValidDiscount()){
                     this.exceptionFormatter.returnResponseBusinessRuleViolated("Discount is not valid");
                 }
                 if(compensationPlan.hasDuplicateAction()){
                     this.exceptionFormatter.returnResponseBusinessRuleViolated("Compensation plan has actions duplicate");
                 }
                 if(!compensationPlan.isValidActions(this.gateway.findAllActions())){
                     this.exceptionFormatter.returnResponseBusinessRuleViolated("Compensation has actions that are not valid");
                 }
             }
             oldPlan.update(compensationPlan);
             objPlan = this.gateway.save(oldPlan);
         }
         return objPlan;
     }
 
     /**
      * @brief Encuentra un plan de compensación por su identificador único.
      * 
      * Este método busca un plan de compensación específico utilizando su identificador único.
      * 
      * @param planId El identificador único del plan de compensación.
      * @return El objeto CompensationPlan correspondiente al identificador proporcionado.
      * @throws EntityNotFoundException Si el plan de compensación no se encuentra.
      */
     @Override
     public CompensationPlan findByCompensationPlanId(long planId) {
         CompensationPlan response = null;
         if(!this.gateway.existsById(planId)){
             this.exceptionFormatter.returnResponseErrorEntityNotFound("Compensation plan with that id was not found");
         }
         response = this.gateway.findById(planId);
         return response;
     }
 
     /**
      * @brief Encuentra un plan de compensación por su nombre.
      * 
      * Este método busca un plan de compensación específico utilizando su nombre.
      * 
      * @param planName El nombre del plan de compensación.
      * @return El objeto CompensationPlan correspondiente al nombre proporcionado.
      * @throws EntityNotFoundException Si el plan de compensación no se encuentra.
      */
     @Override
     public CompensationPlan findByCompesationPlanName(String planName) {
         CompensationPlan response = null;
         if(!this.gateway.existsByName(planName)){
             this.exceptionFormatter.returnResponseErrorEntityNotFound("Compensation plan with that name was not found");
         }
         response = this.gateway.findByName(planName);
         return response;
     }
     
 }
 