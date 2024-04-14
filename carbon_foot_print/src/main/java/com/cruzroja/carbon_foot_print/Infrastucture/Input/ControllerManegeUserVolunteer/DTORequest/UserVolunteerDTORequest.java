package com.cruzroja.carbon_foot_print.Infrastucture.Input.ControllerManegeUserVolunteer.DTORequest;

import java.util.List;

import com.cruzroja.carbon_foot_print.Infrastucture.Input.UserDTO.DTORequest.UserDTORequest;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UserVolunteerDTORequest extends UserDTORequest {
    @NotBlank(message = "position can't be empty")
    private String position;
}
