/**
 * @file ManegeCalculatorCUIntPort.java
 * @brief Interfaz para la gestión del cálculo de la huella de carbono en la aplicación.
 */

 package com.cruzroja.carbon_foot_print.Application.Input;

 import java.util.List;
 import com.cruzroja.carbon_foot_print.Domain.Calculator.CalculatorResponse;
 import com.cruzroja.carbon_foot_print.Domain.Models.DataCalculator;
 
 /**
  * @interface ManegeCalculatorCUIntPort
  * @brief Interfaz que define las operaciones de cálculo de la huella de carbono.
  * 
  * Esta interfaz proporciona los métodos necesarios para calcular la huella de carbono utilizando datos específicos.
  */
 public interface ManegeCalculatorCUIntPort {
 
     /**
      * @brief Calcula la huella de carbono.
      * 
      * Este método permite calcular la huella de carbono basada en una lista de datos de cálculo proporcionados.
      * 
      * @param data Una lista de objetos DataCalculator que contienen los datos necesarios para el cálculo.
      * @return Un objeto CalculatorResponse que representa el resultado del cálculo de la huella de carbono.
      */
     CalculatorResponse calculeFootPrint(List<DataCalculator> data);
 }
 