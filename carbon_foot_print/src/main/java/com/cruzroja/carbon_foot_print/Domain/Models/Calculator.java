package com.cruzroja.carbon_foot_print.Domain.Models;

import java.util.ArrayList;
import java.util.List;

import com.cruzroja.carbon_foot_print.Domain.Calculator.CalculatorResponse;
import com.cruzroja.carbon_foot_print.Domain.Calculator.DataCalculator;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Calculator {
    private double footPrint;
    private List<DataCalculator> data;
    private CalculatorResponse results;

    public Calculator() {
        this.data = new ArrayList<DataCalculator>();
        this.footPrint = 0;
        this.results = new CalculatorResponse();
    }

    public Calculator(List<DataCalculator> data) {
        this.footPrint = 0;
        this.data = data;
        this.results = new CalculatorResponse();
    }
}
