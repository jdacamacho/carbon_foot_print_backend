/**
 * @file ManageCompensationPlanGatewayIntPort.java
 * @brief Interfaz para la gestión de planes de compensación en el gateway de la aplicación.
 */

 package com.cruzroja.carbon_foot_print.Application.Output;

 import java.util.List;
 import com.cruzroja.carbon_foot_print.Domain.Models.Action;
 import com.cruzroja.carbon_foot_print.Domain.Models.CompensationPlan;
 
 /**
  * @interface ManageCompensationPlanGatewayIntPort
  * @brief Interfaz que define las operaciones de caso de uso para la gestión de planes de compensación en el gateway de la aplicación.
  * 
  * Esta interfaz proporciona los métodos necesarios para interactuar con el sistema de almacenamiento de datos
  * para crear, actualizar, recuperar y gestionar planes de compensación y acciones relacionadas.
  */
 public interface ManageCompensationPlanGatewayIntPort {
 
     /**
      * @brief Recupera todos los planes de compensación.
      * 
      * Este método devuelve una lista de todos los planes de compensación almacenados en el sistema.
      * 
      * @return Una lista de objetos de tipo CompensationPlan que representan todos los planes de compensación.
      */
     public List<CompensationPlan> findAll();
 
     /**
      * @brief Guarda un nuevo plan de compensación.
      * 
      * Este método permite registrar un nuevo plan de compensación en el sistema de almacenamiento de datos.
      * 
      * @param compensationPlan El objeto CompensationPlan que se desea guardar.
      * @return El objeto CompensationPlan que ha sido guardado con éxito.
      */
     public CompensationPlan save(CompensationPlan compensationPlan);
 
     /**
      * @brief Encuentra un plan de compensación por su identificador único.
      * 
      * Este método busca un plan de compensación específico utilizando su identificador único.
      * 
      * @param planId El identificador único del plan de compensación que se desea encontrar.
      * @return El objeto CompensationPlan correspondiente al identificador proporcionado, o null si no se encuentra.
      */
     public CompensationPlan findById(long planId);
 
     /**
      * @brief Encuentra un plan de compensación por su nombre.
      * 
      * Este método busca un plan de compensación específico utilizando su nombre.
      * 
      * @param planName El nombre del plan de compensación que se desea encontrar.
      * @return El objeto CompensationPlan correspondiente al nombre proporcionado, o null si no se encuentra.
      */
     public CompensationPlan findByName(String planName);
 
     /**
      * @brief Verifica si existe un plan de compensación con un identificador específico.
      * 
      * Este método comprueba la existencia de un plan de compensación utilizando su identificador único.
      * 
      * @param planId El identificador único del plan de compensación cuya existencia se desea verificar.
      * @return true si el plan de compensación existe, false en caso contrario.
      */
     public boolean existsById(long planId);
 
     /**
      * @brief Verifica si existe un plan de compensación con un nombre específico.
      * 
      * Este método comprueba la existencia de un plan de compensación utilizando su nombre.
      * 
      * @param planName El nombre del plan de compensación cuya existencia se desea verificar.
      * @return true si el plan de compensación existe, false en caso contrario.
      */
     public boolean existsByName(String planName);
 
     /**
      * @brief Recupera todas las acciones.
      * 
      * Este método devuelve una lista de todas las acciones relacionadas con los planes de compensación almacenadas en el sistema.
      * 
      * @return Una lista de objetos de tipo Action que representan todas las acciones.
      */
     public List<Action> findAllActions();
 }
 