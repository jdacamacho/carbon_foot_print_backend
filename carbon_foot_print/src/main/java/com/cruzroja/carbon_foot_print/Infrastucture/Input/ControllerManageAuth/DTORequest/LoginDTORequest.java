package com.cruzroja.carbon_foot_print.Infrastucture.Input.ControllerManageAuth.DTORequest;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class LoginDTORequest {

    @NotNull(message = "username can't be null")
    @NotBlank(message = "username can't be empty")
    private String username;

    @NotNull(message = "password can't be null")
    @NotBlank(message = "password can't be empty")
    private String password;

    public LoginDTORequest(){

    }
}
