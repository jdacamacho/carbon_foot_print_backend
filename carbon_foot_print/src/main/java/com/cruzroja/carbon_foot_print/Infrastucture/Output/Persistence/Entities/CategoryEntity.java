package com.cruzroja.carbon_foot_print.Infrastucture.Output.Persistence.Entities;

import java.util.List;

import java.util.ArrayList;

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
import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * Clase de entidad que representa una categoría en la capa de persistencia.
 */
@Entity
@Table(name = "categories")
@Data
@AllArgsConstructor
public class CategoryEntity {

    /** Identificador único de la categoría. */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long categoryId;

    /** Nombre de la categoría. */
    @Column(nullable = false, length = 45)
    private String categoryName;

    /** Descripción de la categoría. */
    @Column(nullable = false, length = 100)
    private String categoryDescription;

    /** Ámbito de la categoría. */
    @Column(nullable = false, length = 45)
    private String categoryScope;

    @Column(nullable = false)
    private boolean categoryState;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "category_pollution", joinColumns = @JoinColumn(name = "category_id"), inverseJoinColumns = @JoinColumn(name = "pollution_type_id"))
    private List<PollutionTypeEntity> pollutions;

    /**
     * Constructor de la clase CategoryEntity.
     */
    public CategoryEntity() {
        this.pollutions = new ArrayList<PollutionTypeEntity>();
    }
}
