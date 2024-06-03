/**
 * @file UserVolunteerDTORequest.java
 * @brief Clase DTO para la creación de un voluntario.
 */

package com.cruzroja.carbon_foot_print.Infrastucture.Input.ControllerManegeUserVolunteer.DTORequest;

import com.cruzroja.carbon_foot_print.Infrastucture.Input.UserDTO.DTORequest.UserDTORequest;
import com.cruzroja.carbon_foot_print.Infrastucture.Input.ControllerManageRole.DTORequest.RoleWithIdDTORequest;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * @class UserVolunteerDTORequest
 * @brief DTO para la creación de un voluntario.
 * 
 * Esta clase implementa un DTO para la creación de un voluntario.
 */
@Getter
@Setter
public class UserVolunteerDTORequest extends UserDTORequest {
    /** @brief Posición del voluntario. */
    @NotBlank(message = "position can't be empty")
    private String position;

    /**
     * @brief Constructor de la clase.
     */
    public UserVolunteerDTORequest() {
    }

    /**
     * @brief Constructor de la clase.
     * 
     * @param documentNumber Número de documento.
     * @param documentType Tipo de documento.
     * @param names Nombres.
     * @param lastNames Apellidos.
     * @param personalPhone Teléfono personal.
     * @param personalEmail Correo electrónico personal.
     * @param username Nombre de usuario.
     * @param password Contraseña.
     * @param roles Lista de roles.
     * @param position Posición.
     */    
    public UserVolunteerDTORequest(long documentNumber, String documentType,
            String names, String lastNames, String personalPhone,
            String personalEmail, String username, String password,
            List<RoleWithIdDTORequest> roles, String position) {
        super(documentNumber, documentType,
                names, lastNames, personalPhone,
                personalEmail, username, password,
                roles, true);
        this.position = position;
    }

}
