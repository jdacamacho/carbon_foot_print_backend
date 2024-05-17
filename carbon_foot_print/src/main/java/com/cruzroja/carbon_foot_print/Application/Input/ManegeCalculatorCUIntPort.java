package com.cruzroja.carbon_foot_print.Application.Input;

import java.util.List;

import com.cruzroja.carbon_foot_print.Domain.Models.DataCalculator;

public interface ManegeCalculatorCUIntPort {
    double calculeFootPrint(List<DataCalculator> data);

    List<Double> calculeAnnualFootPrint(List<DataCalculator> data);

}
