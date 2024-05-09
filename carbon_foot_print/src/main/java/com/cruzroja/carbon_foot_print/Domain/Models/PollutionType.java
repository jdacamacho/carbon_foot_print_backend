package com.cruzroja.carbon_foot_print.Domain.Models;

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

    public void update(String name, String description, double emissionFactor, String units) {
        this.pollutionTypeName = name;
        this.pollutionTypeDescription = description;
        this.pollutionTypeEmissionFactor = emissionFactor;
        this.pollutionTypeUnits = units;
    }

}
