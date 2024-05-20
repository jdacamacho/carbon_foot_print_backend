package com.cruzroja.carbon_foot_print.Domain.Calculator;

import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class MonthResult {
    private int year;
    private List<Double> month;
    private double total;

    public MonthResult() {
        this.month = new ArrayList<>();
        this.total = 0;
    }

    public void addMonth(double value) {
        this.month.add(value);
        this.total += value;
    }
}
