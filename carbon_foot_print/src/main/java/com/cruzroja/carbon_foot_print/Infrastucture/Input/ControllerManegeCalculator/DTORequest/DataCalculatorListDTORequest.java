package com.cruzroja.carbon_foot_print.Infrastucture.Input.ControllerManegeCalculator.DTORequest;

import java.util.ArrayList;
import java.util.List;

import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class DataCalculatorListDTORequest {
    private List<DataCalculatorDTORequest> data;

    public DataCalculatorListDTORequest() {
        this.data = new ArrayList<>();
    }
}
