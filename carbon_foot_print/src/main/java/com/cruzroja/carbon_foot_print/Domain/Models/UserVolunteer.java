package com.cruzroja.carbon_foot_print.Domain.Models;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * Clase que representa un usuario voluntario en el sistema.
 * Los usuarios voluntarios son individuos que ofrecen su tiempo y esfuerzo de forma no remunerada para contribuir a la huella de carbono.
 */
@Getter
@Setter
public class UserVolunteer extends User {
    
    /** Posición del voluntario en la organización o proyecto. */
    private String position;

    /**
     * Constructor de la clase UserVolunteer.
     */
    public UserVolunteer() {}

    /**
     * Constructor de la clase UserVolunteer con todos los atributos.
     * 
     * @param documentNumber Número de documento del voluntario.
     * @param documentType   Tipo de documento del voluntario.
     * @param names          Nombres del voluntario.
     * @param lastNames      Apellidos del voluntario.
     * @param personalPhone  Teléfono personal del voluntario.
     * @param personalEmail  Correo electrónico personal del voluntario.
     * @param username       Nombre de usuario del voluntario.
     * @param password       Contraseña del voluntario.
     * @param roles          Lista de roles asociados al voluntario.
     * @param position       Posición del voluntario en la organización o proyecto.
     */
    public UserVolunteer(long documentNumber, String documentType, String names, String lastNames, String personalPhone,
                         String personalEmail, String username, String password, List<Role> roles, String position) {
        super(documentNumber, documentType, names, lastNames, personalPhone, personalEmail, username, password, roles, true);
        this.position = position;
    }

    /**
     * Actualiza los atributos del voluntario.
     * 
     * @param volunteer Voluntario con los nuevos atributos.
     */
    public void update(UserVolunteer volunteer) {
        super.update(volunteer);
        this.position = volunteer.getPosition();
    }
}
