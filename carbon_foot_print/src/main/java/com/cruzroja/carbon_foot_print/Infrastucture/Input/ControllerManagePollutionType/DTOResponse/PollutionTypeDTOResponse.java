package com.cruzroja.carbon_foot_print.Infrastucture.Input.ControllerManagePollutionType.DTOResponse;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class PollutionTypeDTOResponse {
    private long pollutionTypeId;
    private String pollutionTypeName;
    private String pollutionTypeDescription;
    private double pollutionTypeEmissionFactor;
    private String pollutionTypeUnits;

    public PollutionTypeDTOResponse() {

    }
}
