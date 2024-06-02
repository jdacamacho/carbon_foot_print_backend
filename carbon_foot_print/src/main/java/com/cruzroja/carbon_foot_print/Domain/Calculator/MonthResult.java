/**
 * @file MonthResult.java
 * @brief Clase del dominio para representar el resultado del cálculo de la huella de carbono por mes.
 */

 package com.cruzroja.carbon_foot_print.Domain.Calculator;

 import java.util.ArrayList;
 import java.util.List;
 
 import lombok.AllArgsConstructor;
 import lombok.Data;
 
 /**
  * @class MonthResult
  * @brief Clase que encapsula el resultado del cálculo de la huella de carbono por mes.
  * 
  * Esta clase almacena los resultados anuales de la huella de carbono, desglosados por mes.
  */
 @Data
 @AllArgsConstructor
 public class MonthResult {
     /** @brief Año correspondiente al resultado mensual. */
     private int year;
     
     /** @brief Lista de valores de huella de carbono por mes. */
     private List<Double> month;
     
     /** @brief Total de huella de carbono para el año. */
     private double total;
 
     /**
      * @brief Constructor por defecto de la clase MonthResult.
      */
     public MonthResult() {
         this.month = new ArrayList<>();
         this.total = 0;
     }
 
     /**
      * @brief Agrega un valor de huella de carbono para un mes y actualiza el total.
      * 
      * @param value Valor de huella de carbono para el mes.
      */
     public void addMonth(double value) {
         this.month.add(value);
         this.total += value;
     }
 }
 