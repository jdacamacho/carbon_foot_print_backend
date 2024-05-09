package com.cruzroja.carbon_foot_print.Infrastucture.Input.ControllerManagePollutionType.DTOResponse;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class PollutionTypeDTOResponse {
    private long id;
    private String name;
    private String description;
    private double emissionFactor;
    private String units;

    public PollutionTypeDTOResponse(){
        
    }
}
