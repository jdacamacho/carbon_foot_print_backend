package com.cruzroja.carbon_foot_print.Infrastucture.Input.ControllerManageSource.DTORequest;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class SourceWithIdDTORequest {
    @Positive(message = "idSource must be positive or not null")
    private long idSource;

    @NotNull(message = "sourceName can't be null")
    @NotBlank(message = "sourceName can't be empty")
    @Size(min = 2, max = 45, message = "sourceName must be between 2 and 45 characters")
    private String sourceName;

    @NotNull(message = "sourceDescription can't be null")
    @NotBlank(message = "sourceDescription can't be empty")
    @Size(min = 10, max = 100, message = "sourceDescription must be between 2 and 45 characters")
    private String sourceDescription;

    public SourceWithIdDTORequest() {

    }
}
