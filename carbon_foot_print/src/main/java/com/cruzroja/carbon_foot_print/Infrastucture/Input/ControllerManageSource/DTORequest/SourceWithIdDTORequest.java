package com.cruzroja.carbon_foot_print.Infrastucture.Input.ControllerManageSource.DTORequest;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class SourceWithIdDTORequest {
    @Positive(message = "idSource must be positive or not null")
    private long idSource;
    
    @NotNull(message = "sourceName can't be null")
    @NotBlank(message = "sourceName can't be empty")
    private String sourceName;

    public SourceWithIdDTORequest(){

    }
}
