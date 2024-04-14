package com.cruzroja.carbon_foot_print.Infrastucture.Input.ControllerManegeUserVolunteer.DTORequest;

import com.cruzroja.carbon_foot_print.Infrastucture.Input.UserDTO.DTORequest.UserDTORequest;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
@AllArgsConstructor
public class UserVolunteerDTORequest extends UserDTORequest {
    @NotBlank(message = "position can't be empty")
    private String position;
}
