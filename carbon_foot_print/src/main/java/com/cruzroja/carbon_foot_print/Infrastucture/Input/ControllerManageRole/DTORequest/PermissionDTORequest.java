package com.cruzroja.carbon_foot_print.Infrastucture.Input.ControllerManageRole.DTORequest;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class PermissionDTORequest {
    @Positive(message = "idPermission must be major than zero")
    private long idPermission;

    @NotNull(message = "name can't be null")
    @NotBlank(message = "name can't be empty")
    private String name;

    @NotNull(message = "description can't be null")
    @NotBlank(message = "description can't be empty")
    private String description;

    public PermissionDTORequest(){

    }

}
