package com.cruzroja.carbon_foot_print.Domain.Models;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * Clase que representa un permiso en el sistema
 */
@Data
@AllArgsConstructor
public class Permission {
    
    /** Identificador único del permiso */
    private long idPermission;
    
    /** Nombre del permiso */
    private String name;
    
    /** Descripción del permiso */
    private String description;

    /**
     * Constructor vacío de la clase Permission.
     */
    public Permission(){

    }
}