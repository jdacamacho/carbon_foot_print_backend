package com.cruzroja.carbon_foot_print.Infrastucture.Input.UserDTO.DTORequest;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class RoleDTORequest {
    @Positive(message = "idRole must be positive")
    private long id;

    @NotNull(message = "typeRole can't be null")
    @NotBlank(message = "typeRole can't be empty")
    private String typeRole;

    public RoleDTORequest(){

    }
}
