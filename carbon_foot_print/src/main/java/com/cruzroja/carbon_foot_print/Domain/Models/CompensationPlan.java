/**
 * @file CompensationPlan.java
 * @brief Clase que representa un plan de compensación en el dominio del modelo.
 */

 package com.cruzroja.carbon_foot_print.Domain.Models;

 import java.util.ArrayList;
 import java.util.HashSet;
 import java.util.List;
 import java.util.Set;
 
 import lombok.AllArgsConstructor;
 import lombok.Data;
 
 /**
  * @class CompensationPlan
  * @brief Clase que representa un plan de compensación.
  *
  * Esta clase incluye los atributos y métodos necesarios para gestionar un plan de compensación.
  */
 @Data
 @AllArgsConstructor
 public class CompensationPlan {
     /** @brief Identificador único del plan. */
     private long planId;
 
     /** @brief Nombre del plan. */
     private String planName;
 
     /** @brief Precio del plan. */
     private double planPrice;
 
     /** @brief Descripción del plan. */
     private String planDescription;
 
     /** @brief Descuento aplicado al plan. */
     private double planDiscount;
 
     /** @brief Lista de acciones incluidas en el plan. */
     private List<Action> actions;
 
     /**
      * @brief Constructor por defecto.
      *
      * Inicializa la lista de acciones como una nueva lista vacía.
      */
     public CompensationPlan(){
         this.actions = new ArrayList<>();
     }
 
     /**
      * @brief Calcula el precio del plan basado en las acciones y el descuento.
      *
      * Recorre la lista de acciones, suma sus precios unitarios y aplica el descuento al precio total.
      */
     public void calculatePrice(){
         double priceActions = 0;
         double newPrice = 0;
         this.setPlanPrice(0);
         for(int i = 0 ; i < this.actions.size() ; i++){
             priceActions = priceActions + this.actions.get(i).getActionUnitaryPrice();
         }
         newPrice = priceActions - (priceActions*(this.planDiscount/100));
         System.out.println("descuento " + (priceActions*(this.planDiscount/100)));
         this.setPlanPrice(newPrice);
     }
 
     /**
      * @brief Compara el nombre del plan actual con el nombre de otro plan.
      *
      * @param compensationPlan El plan de compensación a comparar.
      * @return true si los nombres de los planes son iguales, false en caso contrario.
      */
     public boolean isPlanNameEqual(CompensationPlan compensationPlan){
         return this.planName.equals(compensationPlan.getPlanName());
     }
 
     /**
      * @brief Actualiza los atributos del plan actual con los atributos de otro plan.
      *
      * @param compensationPlan El plan de compensación con los nuevos valores.
      */
     public void update(CompensationPlan compensationPlan){
         this.setPlanName(compensationPlan.getPlanName());
         this.setPlanDescription(compensationPlan.getPlanDescription());
         this.setActions(compensationPlan.getActions());
         this.setPlanDiscount(compensationPlan.getPlanDiscount());
         this.calculatePrice();
     }
 
     /**
      * @brief Verifica si el descuento del plan es válido.
      *
      * Un descuento es válido si está entre 0 y 100 inclusive.
      * 
      * @return true si el descuento es válido, false en caso contrario.
      */
     public boolean isValidDiscount(){
         double discount = this.getPlanDiscount(); 
         if(discount >= 0 && discount <= 100){
             return true;
         }
         return false;
     }
 
     /**
      * @brief Verifica si las acciones del plan son válidas.
      *
      * Una acción es válida si está presente en la lista de acciones válidas proporcionadas.
      * 
      * @param validActions Lista de acciones válidas.
      * @return true si todas las acciones del plan son válidas, false en caso contrario.
      */
     public boolean isValidActions(List<Action> validActions){
         List<Action> actions = this.getActions();
         int wasFound = 0;
         for (Action action : actions) {
             for (Action validAction : validActions) {
                 if(action.equals(validAction)) wasFound ++;
             }
         }
         return actions.size() == wasFound;
     } 
 
     /**
      * @brief Verifica si el plan tiene acciones duplicadas.
      * 
      * @return true si hay acciones duplicadas, false en caso contrario.
      */
     public boolean hasDuplicateAction(){
         Set<Action> actionSet = new HashSet<>(this.getActions());
         return actionSet.size() < this.getActions().size();
     }
 
 }
 