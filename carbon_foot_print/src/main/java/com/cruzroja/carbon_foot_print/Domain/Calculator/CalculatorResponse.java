package com.cruzroja.carbon_foot_print.Domain.Calculator;

import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CalculatorResponse {
    private double total;
    private List<SourceResult> totalBySources;
    private List<MonthResult> totalByMonth;
    private List<SourceResult> percentage;

    public CalculatorResponse() {
        this.total = 0;
        this.totalBySources = new ArrayList<>();
        this.totalByMonth = new ArrayList<>();
        this.percentage = new ArrayList<>();
    }

    public void addMonth(MonthResult result) {
        this.totalByMonth.add(result);
        this.total += result.getTotal();
    }

    public void addSource(SourceResult result) {
        this.totalBySources.add(result);
    }

    public void calculePercentage() {
        for (SourceResult sr : totalBySources) {
            percentage.add(new SourceResult(sr.getSource(), (sr.getTotal() / this.total)));
        }
    }

    public double calculeTotal() {
        double total = 0;
        for (MonthResult month : this.totalByMonth) {
            total += month.getTotal();
        }
        return total;
    }
}
