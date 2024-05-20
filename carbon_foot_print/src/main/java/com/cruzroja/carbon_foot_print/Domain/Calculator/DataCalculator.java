package com.cruzroja.carbon_foot_print.Domain.Calculator;

import com.cruzroja.carbon_foot_print.Domain.Models.PollutionSource;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class DataCalculator {
    private PollutionSource pollutionSource;
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

    public void setMonth(int month) {
        this.month = month;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void setConsume(double consume) {
        this.consume = consume;
        this.footPrint = calculeFootPrint();
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public void setSources(int sources) {
        this.sources = sources;
        this.coverge = calculeCoverge();
    }

    public void setInformedSources(int informedSources) {
        this.informedSources = informedSources;
        this.coverge = calculeCoverge();
    }

    public void setCoverge(double coverge) {
        this.coverge = calculeCoverge();
    }

    public void setFootPrint(double footPrint) {
        this.footPrint = calculeFootPrint();
    }

    public double calculeCoverge() {
        if (this.sources > 0)
            return (this.informedSources / this.sources) * 100;
        return 0;
    }

    public double calculeFootPrint() {
        return this.consume * this.pollutionSource.getPollution().getPollutionTypeEmissionFactor();
    }

}
