package com.cruzroja.carbon_foot_print.Domain.Models;

import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * Representa un tipo de contaminación en la aplicación de huella de carbono.
 */
@Data
@AllArgsConstructor
public class PollutionType {

    /** Identificador único del tipo de contaminación. */
    private long pollutionTypeId;

    /** Nombre del tipo de contaminación. */
    private String pollutionTypeName;

    /** Descripción del tipo de contaminación. */
    private String pollutionTypeDescription;

    /** Factor de emisión del tipo de contaminación. */
    private double pollutionTypeEmissionFactor;

    /** Unidades del factor de emisión del tipo de contaminación. */
    private String pollutionTypeUnits;
    private List<Source> pollutionSources;

    /**
     * Constructor de la clase PollutionType.
     */
    public PollutionType() {
        this.pollutionSources = new ArrayList<Source>();
    }

    /**
     * Actualiza los atributos del tipo de contaminación con los valores
     * proporcionados.
     * 
     * @param name           Nombre del tipo de contaminación.
     * @param description    Descripción del tipo de contaminación.
     * @param emissionFactor Factor de emisión del tipo de contaminación.
     * @param units          Unidades del factor de emisión del tipo de
     *                       contaminación.
     */
    public void update(PollutionType newValues) {
        this.pollutionTypeName = newValues.getPollutionTypeName();
        this.pollutionTypeDescription = newValues.getPollutionTypeDescription();
        this.pollutionTypeEmissionFactor = newValues.getPollutionTypeEmissionFactor();
        this.pollutionTypeUnits = newValues.getPollutionTypeUnits();
        this.pollutionSources = newValues.getPollutionSources();
    }

    /**
     * Verifica si se quiere actualizar el nombre
     * 
     * @param name {@code String} "nuevo" nombre del pollution type
     * @return {@code true} en caso de que sea diferente y falso en caso contrario.
     */
    public boolean isNameUpdate(String name) {
        return !this.pollutionTypeName.equals(name);
    }

    /**
     * Verifica si las unidades ingresadas son válidas los valores aceptados son
     * [Metro Cúbico
     * - Galón
     * - Kilogramo]
     * 
     * @return {@code true} en caso de que sea valido el valor ingresado,
     *         {@code false} en caso contrario
     */
    public boolean isValidUnits() {
        List<String> units = new ArrayList<String>();
        units.add("Metro Cúbico");
        units.add("Galón");
        units.add("Kilogramo");

        return units.contains(this.pollutionTypeUnits);
    }

    /**
     * Valida si los pollution source son validos.
     * 
     * @param valids {@code List<Source>} lista de fuentes validas.
     * @return {@code true} en caso de que todos los sources del objeto estén en la
     *         lista se validos y {@code false} en caso contrario
     */
    public boolean isValidSources(List<Source> valids) {
        return valids.containsAll(this.pollutionSources);

    }

}
