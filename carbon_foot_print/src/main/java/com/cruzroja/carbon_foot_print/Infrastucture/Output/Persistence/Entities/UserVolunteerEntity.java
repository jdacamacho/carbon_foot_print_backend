package com.cruzroja.carbon_foot_print.Infrastucture.Output.Persistence.Entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * Clase de entidad que representa un voluntario en la capa de persistencia.
 * Esta entidad mapea la tabla "Volunteers" en la base de datos, que almacena información sobre los voluntarios del sistema.
 * 
 * Contiene los siguientes atributos:
 * - documentNumber: Número de documento del voluntario.
 * - documentType: Tipo de documento del voluntario.
 * - names: Nombres del voluntario.
 * - lastNames: Apellidos del voluntario.
 * - personalPhone: Teléfono personal del voluntario.
 * - personalEmail: Correo electrónico personal del voluntario.
 * - username: Nombre de usuario del voluntario.
 * - password: Contraseña del voluntario.
 * - roles: Lista de roles asociados al voluntario.
 * - state: Estado del voluntario.
 * - position: Posición del voluntario.
 */
@Entity
@Table(name = "Volunteers")
@Getter
@Setter
public class UserVolunteerEntity extends UserEntity {
    
    /** Posición del voluntario. */
    @Column(nullable = false, length = 45)
    private String position;

    /**
     * Constructor de la clase UserVolunteerEntity.
     */
    public UserVolunteerEntity() {

    }

    /**
     * Constructor de la clase UserVolunteerEntity con parámetros.
     * 
     * @param documentNumber Número de documento del voluntario.
     * @param documentType Tipo de documento del voluntario.
     * @param names Nombres del voluntario.
     * @param lastNames Apellidos del voluntario.
     * @param personalPhone Teléfono personal del voluntario.
     * @param personalEmail Correo electrónico personal del voluntario.
     * @param username Nombre de usuario del voluntario.
     * @param password Contraseña del voluntario.
     * @param roles Lista de roles asociados al voluntario.
     * @param position Posición del voluntario.
     */
    public UserVolunteerEntity(long documentNumber, String documentType,
            String names, String lastNames, String personalPhone,
            String personalEmail, String username, String password,
            List<RoleEntity> roles, String position) {
        super(documentNumber, documentType,
                names, lastNames, personalPhone,
                personalEmail, username, password,
                roles, true);
        this.position = position;
    }
}
