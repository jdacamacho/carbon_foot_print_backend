package com.cruzroja.carbon_foot_print.Domain.Models;


import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * Clase que representa las credenciales de usuario.
 */
@Data
@AllArgsConstructor
public class Credential {
    
    /** Número de documento asociado a las credenciales. */
    private long documentNumber;
    
    /** Nombre de usuario asociado a las credenciales. */
    private String username;
    
    /** Token de autenticación asociado a las credenciales. */
    private String token;

    /**
     * Constructor de la clase Credential.
     */
    public Credential(){

    }
}
