package com.cruzroja.carbon_foot_print.Infrastucture.Input.ControllerManageRole.DTORequest;

import java.util.ArrayList;
import java.util.List;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class RoleWithIdDTORequest {
    @Positive(message = "idRole must be positive")
    private long idRole;

    @NotNull(message = "typeRole can't be null")
    @NotBlank(message = "typeRole can't be empty")
    @Size(min = 10 , max = 45, message = "Type role must between 10 and 45 characters")
    private String typeRole;

    @NotNull(message = "Role must have a state in the system")
    private boolean state;

    @Size(min = 1, message = "User must have at least one role")
    @Valid
    List<PermissionDTORequest> permissions;

    public RoleWithIdDTORequest(){
        this.permissions = new ArrayList<>();
    }
}
