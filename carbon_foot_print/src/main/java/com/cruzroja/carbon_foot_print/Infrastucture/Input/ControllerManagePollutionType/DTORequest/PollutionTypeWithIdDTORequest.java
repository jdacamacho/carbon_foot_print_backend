package com.cruzroja.carbon_foot_print.Infrastucture.Input.ControllerManagePollutionType.DTORequest;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class PollutionTypeWithIdDTORequest {
    @Positive(message = "pollutionTypeId must be positive")
    @NotNull(message = "pollutionTypeId can't be null")
    private long pollutionTypeId;
    @NotNull(message = "name can't be null")
    @NotBlank(message = "name can't be empty")
    private String pollutionTypeName;

    @NotNull(message = "description can't be null")
    @NotBlank(message = "description can't be empty")
    private String pollutionTypeDescription;

    @NotNull(message = "emissionFactor can't be null")
    private double pollutionTypeEmissionFactor;

    @NotNull(message = "units can't be null")
    @NotBlank(message = "units can't be empty")
    private String pollutionTypeUnits;

    public PollutionTypeWithIdDTORequest() {

    }
}