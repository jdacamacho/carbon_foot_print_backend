package com.cruzroja.carbon_foot_print.Infrastucture.Input.ControllerManageRole.DTORequest;

import java.util.ArrayList;
import java.util.List;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class RoleDTORequest {
    @Positive(message = "idRole must be positive")
    private long idRole;

    @NotNull(message = "typeRole can't be null")
    @NotBlank(message = "typeRole can't be empty")
    private String typeRole;

    @Valid
    List<PermissionDTORequest> permissions;
    
    public RoleDTORequest(){
        this.permissions = new ArrayList<>();
    }
}