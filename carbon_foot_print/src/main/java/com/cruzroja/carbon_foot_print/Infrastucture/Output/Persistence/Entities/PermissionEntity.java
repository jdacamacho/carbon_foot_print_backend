package com.cruzroja.carbon_foot_print.Infrastucture.Output.Persistence.Entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * Clase de entidad que representa un permiso en la capa de persistencia.
 */
@Entity
@Table(name = "permissions")
@Data
@AllArgsConstructor
public class PermissionEntity {
    
    /** Identificador único del permiso. */
    @Id
    private long idPermission;
    
    /** Nombre del permiso. */
    @Column(nullable = false, unique = true, length = 45)
    private String name;
    
    /** Descripción del permiso. */
    @Column(nullable = false, unique = false, length = 80)
    private String description;

    /**
     * Constructor de la clase PermissionEntity.
     */
    public PermissionEntity(){

    }

}
