/**
 * @file UserVolunteerDTOResponse.java
 * @brief DTO para la respuesta de un voluntario.
 */
package com.cruzroja.carbon_foot_print.Infrastucture.Input.ControllerManegeUserVolunteer.DTOResponse;

import com.cruzroja.carbon_foot_print.Infrastucture.Input.UserDTO.DTOResponse.UserDTOResponse;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @class UserVolunteerDTOResponse
 * @brief DTO para la respuesta de un voluntario.
 * 
 * Esta clase implementa un DTO para la respuesta de un voluntario.
 */

@Data
@EqualsAndHashCode(callSuper = false)
@AllArgsConstructor
public class UserVolunteerDTOResponse extends UserDTOResponse {
    /** @brief Posición del voluntario. */
    private String position;

    /**
     * @brief Constructor de la clase.
     */
    
    public UserVolunteerDTOResponse() {
        super();
    }
}
