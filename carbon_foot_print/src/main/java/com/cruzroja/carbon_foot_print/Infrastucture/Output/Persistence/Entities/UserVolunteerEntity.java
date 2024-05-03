package com.cruzroja.carbon_foot_print.Infrastucture.Output.Persistence.Entities;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * Clase de entidad que representa un voluntario en la capa de persistencia.
 */
@Entity
@Table(name = "Volunteers")
@Getter
@Setter
@AllArgsConstructor
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
     * Constructor de la clase UserVolunteerEntity con parametros.
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
