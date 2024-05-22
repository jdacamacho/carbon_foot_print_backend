package com.cruzroja.carbon_foot_print.Infrastucture.Input.ControllerManegeCalculator.DTOResponse;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class MonthResultDTOResponse {
    private int year;
    private List<Double> month;
    private double total;

    public MonthResultDTOResponse() {
    }
}
