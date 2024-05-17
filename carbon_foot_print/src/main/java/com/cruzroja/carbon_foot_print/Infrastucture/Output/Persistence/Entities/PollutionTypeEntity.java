/**
 * @file PollutionTypeEntity.java
 * @brief Este archivo contiene la definición de la entidad PollutionTypeEntity para la persistencia de tipos de contaminación en la base de datos.
 */

package com.cruzroja.carbon_foot_print.Infrastucture.Output.Persistence.Entities;

import java.util.List;
import java.util.ArrayList;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "pollution_types")
@Getter
@Setter
@AllArgsConstructor
public class PollutionTypeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long pollutionTypeId;

    @Column(nullable = false, unique = true)
    private String pollutionTypeName;

    @Column(nullable = false)
    private String pollutionTypeDescription;

    @Column(nullable = false)
    private double pollutionTypeEmissionFactor;

    @Column(nullable = false)
    private String pollutionTypeUnits;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "pollution_source", joinColumns = @JoinColumn(name = "source_id"), inverseJoinColumns = @JoinColumn(name = "pollution_id"))
    private List<SourceEntity> pollutionSources;

    public PollutionTypeEntity() {
        this.pollutionSources = new ArrayList<SourceEntity>();
    }

}
