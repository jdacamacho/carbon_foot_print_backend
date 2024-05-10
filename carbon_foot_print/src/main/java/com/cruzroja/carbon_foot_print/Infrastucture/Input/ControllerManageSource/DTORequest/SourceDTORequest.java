package com.cruzroja.carbon_foot_print.Infrastucture.Input.ControllerManageSource.DTORequest;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class SourceDTORequest {
    @NotNull(message = "sourceName can't be null")
    @NotBlank(message = "sourceName can't be empty")
    private String sourceName;

    public SourceDTORequest(){

    }
}
