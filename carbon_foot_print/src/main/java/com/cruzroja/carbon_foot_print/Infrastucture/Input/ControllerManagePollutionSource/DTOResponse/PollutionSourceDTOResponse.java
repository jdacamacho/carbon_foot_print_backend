package com.cruzroja.carbon_foot_print.Infrastucture.Input.ControllerManagePollutionSource.DTOResponse;

import com.cruzroja.carbon_foot_print.Infrastucture.Input.ControllerManagePollutionType.DTOResponse.PollutionTypeDTOResponse;
import com.cruzroja.carbon_foot_print.Infrastucture.Input.ControllerManageSource.DTOResponse.SourceDTOResponse;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class PollutionSourceDTOResponse {
    private PollutionTypeDTOResponse pollution;
    private SourceDTOResponse source;

    public PollutionSourceDTOResponse(){
        
    }
}
