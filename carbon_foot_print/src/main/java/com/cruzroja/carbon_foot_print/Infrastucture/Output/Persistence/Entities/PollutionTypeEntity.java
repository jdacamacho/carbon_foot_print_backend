package com.cruzroja.carbon_foot_print.Infrastucture.Output.Persistence.Entities;

import lombok.Getter;
import lombok.Setter;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "pollution_types")
@Getter
@Setter
public class PollutionTypeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String name;

    @Column(nullable = false)
    private String description;

    @Column(nullable = false)
    private double emissionFactor;

    @Column(nullable = false)
    private String units;


    public PollutionTypeEntity() {
    }

    public PollutionTypeEntity(String name, String description, double emissionFactor, String units) {
        this.name = name;
        this.description = description;
        this.emissionFactor = emissionFactor;
        this.units = units;
    }
}
