package com.cruzroja.carbon_foot_print.Infrastucture.Output.Persistence.Entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;

/*Entidad que representa una acción.*/
@Entity
@Table(name = "actions")
@Data
@AllArgsConstructor
public class ActionEntity {

    /*Identificador único de la acción.*/
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long actionId;

    /**
     * Nombre de la acción.
     * No puede ser nulo y tiene una longitud máxima de 45 caracteres.*/
    @Column(nullable = false, length = 45)
    private String actionName;

    /**
     * Descripción de la acción.
     * No puede ser nulo y tiene una longitud máxima de 100 caracteres.*/
    @Column(nullable = false, length = 100)
    private String actionDescription;

    /**Precio unitario de la acción,No puede ser nulo.*/
    @Column(nullable = false)
    private double actionUnitaryPrice;

    @Column(nullable = false)
    private double actionUfp;

    /**Constructor sin parámetros.*/
    public ActionEntity() {
    }
}
