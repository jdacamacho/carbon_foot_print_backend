package com.cruzroja.carbon_foot_print.Domain.Models;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * Clase que representa las credenciales de un usuario en el sistema.
 * Esta clase almacena el número de documento del usuario, su nombre de usuario,
 * y el token de autenticación asociado.
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
     * Crea una nueva instancia de las credenciales del usuario.
     */
    public Credential(){

    }
}
