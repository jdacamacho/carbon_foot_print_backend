package com.cruzroja.carbon_foot_print.Infrastucture.Input.ControllerManagePollutionType.DTORequest;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class PollutionTypeDTORequest {

    @NotNull(message = "pollutionTypeName can't be null")
    @NotBlank(message = "pollutionTypeName can't be empty")
    private String pollutionTypeName;

    @NotNull(message = "pollutionTypeDescription can't be null")
    @NotBlank(message = "pollutionTypeDescription can't be empty")
    private String pollutionTypeDescription;

    @NotNull(message = "pollutionTypeEmissionFactor can't be null")
    @Positive(message = "pollutionTypeEmissionFactor must be positive")
    private double pollutionTypeEmissionFactor;

    @NotNull(message = "pollutionTypeUnits can't be null")
    @NotBlank(message = "pollutionTypeUnits can't be empty")
    private String pollutionTypeUnits;

    public PollutionTypeDTORequest() {

    }
}
