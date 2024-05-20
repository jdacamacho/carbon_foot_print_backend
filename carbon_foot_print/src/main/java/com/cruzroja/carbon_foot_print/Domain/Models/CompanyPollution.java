package com.cruzroja.carbon_foot_print.Domain.Models;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CompanyPollution {
    private long pollutionId;
    private long sourceId;
    private int year;
    private int month;
    private double consume;
    private double cost;
    private int informedSorce;
    private int totalSource;

    public CompanyPollution() {
    }

}
