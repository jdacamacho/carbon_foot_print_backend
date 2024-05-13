package com.cruzroja.carbon_foot_print.Domain.Models;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * Representa un tipo de contaminación en la aplicación de huella de carbono.
 */
@Data
@AllArgsConstructor
public class PollutionType {
    
    /** Identificador único del tipo de contaminación. */
    private long id;
    
    /** Nombre del tipo de contaminación. */
    private String name;
    
    /** Descripción del tipo de contaminación. */
    private String description;
    
    /** Factor de emisión del tipo de contaminación. */
    private double emissionFactor;
    
    /** Unidades del factor de emisión del tipo de contaminación. */
    private String units;

    /**
     * Constructor de la clase PollutionType.
     */
    public PollutionType() {

    }

    /**
     * Actualiza los atributos del tipo de contaminación con los valores proporcionados.
     * @param name Nombre del tipo de contaminación.
     * @param description Descripción del tipo de contaminación.
     * @param emissionFactor Factor de emisión del tipo de contaminación.
     * @param units Unidades del factor de emisión del tipo de contaminación.
     */
    public void update(String name, String description, double emissionFactor, String units){
        this.name = name;
        this.description = description;
        this.emissionFactor = emissionFactor;
        this.units = units;
    }

}
