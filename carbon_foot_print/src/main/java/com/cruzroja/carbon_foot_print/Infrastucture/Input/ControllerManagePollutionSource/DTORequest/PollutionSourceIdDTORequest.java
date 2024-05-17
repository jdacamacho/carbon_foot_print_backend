package com.cruzroja.carbon_foot_print.Infrastucture.Input.ControllerManagePollutionSource.DTORequest;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class PollutionSourceIdDTORequest {
    private long idPollution;
    private long idSource;

    public PollutionSourceIdDTORequest(){
        
    }
}
