package com.cruzroja.carbon_foot_print.Infrastucture.Input.ControllerManegeCalculator.DTOResponse;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CalculatorResponseDTOResponse {
    private double total;
    private List<SourceResultDTOResponse> totalBySources;
    private List<MonthResultDTOResponse> totalByMonth;
    private List<SourceResultDTOResponse> percentage;
}
