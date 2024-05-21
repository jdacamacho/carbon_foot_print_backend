package com.cruzroja.carbon_foot_print.Application.Input;

import java.util.List;

import com.cruzroja.carbon_foot_print.Domain.Calculator.CalculatorResponse;
import com.cruzroja.carbon_foot_print.Domain.Models.DataCalculator;

public interface ManegeCalculatorCUIntPort {
    CalculatorResponse calculeFootPrint(List<DataCalculator> data);
}
