package com.cruzroja.carbon_foot_print.Infrastucture.Input.ControllerManegeUserVolunteer.DTORequest;

import java.util.List;

import com.cruzroja.carbon_foot_print.Infrastucture.Input.ControllerManageRole.DTORequest.RoleWithIdDTORequest;
import com.cruzroja.carbon_foot_print.Infrastucture.Input.UserDTO.DTORequest.UserUpdateDTORequest;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserVolunteerUpdateDTORequest extends UserUpdateDTORequest{
    @NotBlank(message = "position can't be empty")
    private String position;

    public UserVolunteerUpdateDTORequest() {
    }

    public UserVolunteerUpdateDTORequest(long documentNumber, String documentType,
            String names, String lastNames, String personalPhone,
            String personalEmail, String username,
            List<RoleWithIdDTORequest> roles, String position) {
        super(documentNumber, documentType,
                names, lastNames, personalPhone,
                personalEmail, username,
                roles, true);
        this.position = position;
    }

}
