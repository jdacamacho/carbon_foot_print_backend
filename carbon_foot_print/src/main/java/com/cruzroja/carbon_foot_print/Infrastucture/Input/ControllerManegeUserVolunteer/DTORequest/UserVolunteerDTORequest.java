package com.cruzroja.carbon_foot_print.Infrastucture.Input.ControllerManegeUserVolunteer.DTORequest;

import com.cruzroja.carbon_foot_print.Infrastucture.Input.UserDTO.DTORequest.UserDTORequest;
import com.cruzroja.carbon_foot_print.Infrastucture.Input.ControllerManageRole.DTORequest.RoleDTORequest;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class UserVolunteerDTORequest extends UserDTORequest {
    @NotBlank(message = "position can't be empty")
    private String position;

    public UserVolunteerDTORequest() {
    }

    public UserVolunteerDTORequest(long documentNumber, String documentType,
            String names, String lastNames, String personalPhone,
            String personalEmail, String username, String password,
            List<RoleDTORequest> roles, String position) {
        super(documentNumber, documentType,
                names, lastNames, personalPhone,
                personalEmail, username, password,
                roles, true);
        this.position = position;
    }

}
