package com.cruzroja.carbon_foot_print.Infrastucture.Input.ControllerManegeCalculator.DTOResponse;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class SourceResultDTOResponse {
    private String source;
    private double total;

    public SourceResultDTOResponse() {
    }
}
