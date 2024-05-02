package com.cruzroja.carbon_foot_print.Domain.Models;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class PollutionType {
    
    private long id;
    private String name;
    private String description;
    private double emissionFactor;
    private String units;

    public PollutionType() {

    }

    public void update(String name, String description, double emissionFactor, String units){
        this.name = name;
        this.description = description;
        this.emissionFactor = emissionFactor;
        this.units = units;
    }

}
