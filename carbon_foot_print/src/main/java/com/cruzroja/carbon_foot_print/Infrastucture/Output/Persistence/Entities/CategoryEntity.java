package com.cruzroja.carbon_foot_print.Infrastucture.Output.Persistence.Entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
    @Column(nullable = false)
    private String categoryName;

    /** Descripción de la categoría. */
    @Column(nullable = false)
    private String categoryDescription;

    /** Ámbito de la categoría. */
    @Column(nullable = false)
    private String categoryScope;

    /**
     * Constructor de la clase CategoryEntity.
     */
    public CategoryEntity() {
    }
}
