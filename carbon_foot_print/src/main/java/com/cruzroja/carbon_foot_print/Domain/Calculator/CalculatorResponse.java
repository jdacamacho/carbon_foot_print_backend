/**
 * @file CalculatorResponse.java
 * @brief Clase del dominio para representar la respuesta del cálculo de la huella de carbono.
 */

 package com.cruzroja.carbon_foot_print.Domain.Calculator;

 import java.util.ArrayList;
 import java.util.List;
 
 import lombok.AllArgsConstructor;
 import lombok.Data;
 
 /**
  * @class CalculatorResponse
  * @brief Clase que encapsula la respuesta del cálculo de la huella de carbono.
  * 
  * Esta clase almacena los resultados totales del cálculo, incluyendo los totales por fuente y por mes, 
  * así como los porcentajes de contribución de cada fuente.
  */
 @Data
 @AllArgsConstructor
 public class CalculatorResponse {
     /** @brief Total de huella de carbono calculada. */
     private double total;
     
     /** @brief Lista de resultados totales por fuente. */
     private List<SourceResult> totalBySources;
     
     /** @brief Lista de resultados totales por mes. */
     private List<MonthResult> totalByMonth;
     
     /** @brief Lista de porcentajes de contribución por fuente. */
     private List<SourceResult> percentage;
 
     /**
      * @brief Constructor por defecto de la clase CalculatorResponse.
      */
     public CalculatorResponse() {
         this.total = 0;
         this.totalBySources = new ArrayList<>();
         this.totalByMonth = new ArrayList<>();
         this.percentage = new ArrayList<>();
     }
 
     /**
      * @brief Agrega un resultado mensual a la lista y actualiza el total.
      * 
      * @param result Objeto MonthResult que representa el resultado mensual a agregar.
      */
     public void addMonth(MonthResult result) {
         this.totalByMonth.add(result);
         this.total += result.getTotal();
     }
 
     /**
      * @brief Agrega un resultado por fuente a la lista.
      * 
      * @param result Objeto SourceResult que representa el resultado por fuente a agregar.
      */
     public void addSource(SourceResult result) {
         this.totalBySources.add(result);
     }
 
     /**
      * @brief Calcula el porcentaje de contribución de cada fuente y los almacena en la lista de porcentajes.
      */
     public void calculePercentage() {
         for (SourceResult sr : totalBySources) {
             percentage.add(new SourceResult(sr.getSource(), (sr.getTotal() / this.total)));
         }
     }
 
     /**
      * @brief Calcula el total de huella de carbono sumando los totales mensuales.
      * 
      * @return El total de huella de carbono calculada.
      */
     public double calculeTotal() {
         double total = 0;
         for (MonthResult month : this.totalByMonth) {
             total += month.getTotal();
         }
         return total;
     }
 }
 