package com.cruzroja.carbon_foot_print.Domain.Models;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * Clase que representa un permiso en el sistema.
 * Los permisos son utilizados para controlar el acceso a recursos o funcionalidades dentro del sistema.
 */
@Data
@AllArgsConstructor
public class Permission {
    
    /** Identificador único del permiso. */
    private long idPermission;
    
    /** Nombre del permiso. */
    private String name;
    
    /** Descripción del permiso. */
    private String description;

    /**
     * Constructor vacío de la clase Permission.
     * Crea una nueva instancia de un permiso sin inicializar sus atributos.
     */
    public Permission(){

    }
}
