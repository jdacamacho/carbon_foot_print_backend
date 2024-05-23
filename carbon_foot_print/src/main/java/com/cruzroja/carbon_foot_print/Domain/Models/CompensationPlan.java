package com.cruzroja.carbon_foot_print.Domain.Models;

import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CompensationPlan {
    private long planId;
    private String planName;
    private double planPrice;
    private String planDescription;
    private int planDiscount;
    private List<Action> actions;

    public CompensationPlan(){
        this.actions = new ArrayList<>();
    }

}
