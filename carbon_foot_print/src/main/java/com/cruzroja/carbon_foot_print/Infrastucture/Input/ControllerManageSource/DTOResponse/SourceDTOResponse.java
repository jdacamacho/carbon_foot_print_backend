package com.cruzroja.carbon_foot_print.Infrastucture.Input.ControllerManageSource.DTOResponse;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class SourceDTOResponse {
    private long idSource;
    private String sourceName;
    private String sourceDescription;

    public SourceDTOResponse() {

    }
}
