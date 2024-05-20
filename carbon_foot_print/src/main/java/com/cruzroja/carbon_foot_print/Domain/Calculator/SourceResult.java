package com.cruzroja.carbon_foot_print.Domain.Calculator;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class SourceResult {
    private String source;
    private double total;

    public SourceResult() {
    }
}
