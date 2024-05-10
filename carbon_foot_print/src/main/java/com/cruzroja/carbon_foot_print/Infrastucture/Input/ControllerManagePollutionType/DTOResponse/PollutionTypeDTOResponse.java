package com.cruzroja.carbon_foot_print.Infrastucture.Input.ControllerManagePollutionType.DTOResponse;

import java.util.List;

import com.cruzroja.carbon_foot_print.Infrastucture.Input.ControllerManageSource.DTOResponse.SourceDTOResponse;

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
    private List<SourceDTOResponse> pollutionSources;

    public PollutionTypeDTOResponse() {

    }
}
