package com.cruzroja.carbon_foot_print.Infrastucture.Output.Persistence.Entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * Clase de entidad que representa un permiso en la capa de persistencia.
 * Esta entidad mapea la tabla "permissions" en la base de datos, que almacena información sobre los permisos del sistema.
 * 
 * Contiene los siguientes atributos:
 * - idPermission: Identificador único del permiso.
 * - name: Nombre del permiso.
 * - description: Descripción del permiso.
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
    @Column(nullable = false, unique = false, length = 100)
    private String description;

    /**
     * Constructor de la clase PermissionEntity.
     * Este constructor crea una instancia de PermissionEntity sin ningún argumento.
     */
    public PermissionEntity(){

    }

}
