package com.cruzroja.carbon_foot_print.Domain.Calculator;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @class SourceResult
 * @brief Clase que representa el resultado del cálculo de huella de carbono para una fuente específica.
 *
 * La clase SourceResult encapsula los datos relacionados con una fuente particular y la cantidad total de huella de carbono generada por esa fuente.
 * Se utiliza en el proceso de cálculo de huella de carbono para almacenar y organizar los resultados de cada fuente de contaminación.
 */
@Data
@AllArgsConstructor
public class SourceResult {
    
    /**
     * @brief Nombre de la fuente de contaminación.
     *
     * Este atributo almacena el nombre de la fuente de contaminación que está siendo evaluada.
     */
    private String source;
    
    /**
     * @brief Total de huella de carbono generada.
     *
     * Este atributo almacena el valor total de la huella de carbono generada por la fuente especificada.
     */
    private double total;

    /**
     * @brief Constructor por defecto.
     *
     * Crea una instancia de SourceResult sin inicializar los atributos. 
     * Es necesario para el uso de ciertas bibliotecas y frameworks que requieren un constructor vacío.
     */
    public SourceResult() {
    }
}
