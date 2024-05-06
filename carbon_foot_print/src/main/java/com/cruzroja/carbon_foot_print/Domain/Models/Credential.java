package com.cruzroja.carbon_foot_print.Domain.Models;


import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * Clase que representa las credenciales de usuario.
 */
@Data
@AllArgsConstructor
public class Credential {
    
    /** Token de autenticación asociado a las credenciales. */
    private String token;

    private User user;

    /**
     * Constructor de la clase Credential.
     */
    public Credential(){

    }
}
