package com.cruzroja.carbon_foot_print.Infrastucture.Input.ControllerManegeCalculator.DTORequest;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class DataCalculatorDTORequest {
    @Positive(message = "pollutionId must be positive")
    private long pollutionId;
    @Positive(message = "sourceId must be positive")
    private long sourceId;
    @Min(value = 1, message = "month must be between 1-12")
    @Max(value = 12, message = "month must be between 1-12")
    private int month;
    @Min(value = 2000, message = "year must be major or equal than 2000")
    private int year;
    @Positive(message = "consume must be positive")
    private double consume;
    @Positive(message = "cost must be positive")
    private double cost;
    @Positive(message = "sources must be positive")
    private int sources;
    @Positive(message = "informedSources must be positive")
    private int informedSources;

    public DataCalculatorDTORequest() {
    }
}
