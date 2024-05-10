package com.cruzroja.carbon_foot_print.Infrastucture.Input.ControllerManagePollutionType.DTORequest;

import java.util.List;

import com.cruzroja.carbon_foot_print.Infrastucture.Input.ControllerManageSource.DTORequest.SourceDTORequest;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
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
    @NotEmpty(message = "the pollutionSources can't be empty")
    private List<SourceDTORequest> pollutionSources;

    public PollutionTypeWithIdDTORequest() {

    }
}