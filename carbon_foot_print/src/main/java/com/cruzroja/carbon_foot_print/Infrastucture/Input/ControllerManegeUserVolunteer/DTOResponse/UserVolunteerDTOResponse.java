package com.cruzroja.carbon_foot_print.Infrastucture.Input.ControllerManegeUserVolunteer.DTOResponse;

import com.cruzroja.carbon_foot_print.Infrastucture.Input.UserDTO.DTOResponse.UserDTOResponse;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
@AllArgsConstructor
public class UserVolunteerDTOResponse extends UserDTOResponse {
    private String position;

    public UserVolunteerDTOResponse() {
        super();
    }
}
