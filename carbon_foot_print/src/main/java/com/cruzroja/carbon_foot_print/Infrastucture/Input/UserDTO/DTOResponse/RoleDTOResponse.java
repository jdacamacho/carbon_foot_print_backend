package com.cruzroja.carbon_foot_print.Infrastucture.Input.UserDTO.DTOResponse;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class RoleDTOResponse {
    @Positive(message = "idRole must be positive")
    private long id;

    @NotNull(message = "typeRole can't be null")
    @NotBlank(message = "typeRole can't be empty")
    private String typeRole;

    public RoleDTOResponse(){
        
    }
}
