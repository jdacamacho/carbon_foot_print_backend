package com.cruzroja.carbon_foot_print.Domain.Models;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class DataCalculator {
    private PollutionSource pollutionSource;
    private long pollutionId;
    private long sourceId;
    private int month;
    private int year;
    private double consume;
    private double cost;
    private int sources;
    private int informedSources;
    private double coverge;
    private double footPrint;

    public DataCalculator() {
    }

    public void setPollutionSource(PollutionSource pollutionSource) {
        this.pollutionSource = pollutionSource;
        this.footPrint = calculeFootPrint();
    }

    public double calculeCoverge() {
        if (this.sources > 0)
            return ((this.informedSources / this.sources) * 100);
        return 0;
    }

    public double calculeFootPrint() {
        return this.consume * this.pollutionSource.getPollution().getPollutionTypeEmissionFactor();
    }

    public boolean isValidCoverge() {
        return this.informedSources <= this.sources;
    }

    public void calculeData() {
        this.footPrint = calculeFootPrint();
        this.coverge = calculeCoverge();
    }
}
