package com.cruzroja.carbon_foot_print.Domain.Models;

import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class PollutionType {

    private long pollutionTypeId;
    private String pollutionTypeName;
    private String pollutionTypeDescription;
    private double pollutionTypeEmissionFactor;
    private String pollutionTypeUnits;

    public PollutionType() {

    }

    public void update(PollutionType newValues) {
        this.pollutionTypeName = newValues.pollutionTypeName;
        this.pollutionTypeDescription = newValues.pollutionTypeDescription;
        this.pollutionTypeEmissionFactor = newValues.pollutionTypeEmissionFactor;
        this.pollutionTypeUnits = newValues.getPollutionTypeUnits();
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

}
