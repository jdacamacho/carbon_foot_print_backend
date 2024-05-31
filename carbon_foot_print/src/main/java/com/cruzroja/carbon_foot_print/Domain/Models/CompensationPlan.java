package com.cruzroja.carbon_foot_print.Domain.Models;

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
    private double planDiscount;

    public CompensationPlan() {
        this.planPrice = 0;
    }

    public void calculatePrice(List<Double> prices) {
        double priceActions = 0;
        double newPrice = 0;
        this.setPlanPrice(0);
        for (int i = 0; i < prices.size(); i++) {
            priceActions += prices.get(i);
        }
        newPrice = priceActions - (priceActions * (this.planDiscount / 100));
        System.out.println("descuento " + (priceActions * (this.planDiscount / 100)));
        this.setPlanPrice(newPrice);
    }

    public boolean isPlanNameEqual(CompensationPlan compensationPlan) {
        return this.planName.equals(compensationPlan.getPlanName());
    }

    public void update(CompensationPlan compensationPlan, List<Double> prices) {
        this.setPlanName(compensationPlan.getPlanName());
        this.setPlanDescription(compensationPlan.getPlanDescription());
        this.setPlanDiscount(compensationPlan.getPlanDiscount());
        this.calculatePrice(prices);
    }

    public void update(CompensationPlan compensationPlan) {
        this.setPlanName(compensationPlan.getPlanName());
        this.setPlanDescription(compensationPlan.getPlanDescription());
        this.setPlanDiscount(compensationPlan.getPlanDiscount());
    }

    public boolean isValidDiscount() {
        double discount = this.getPlanDiscount();
        if (discount >= 0 && discount <= 100) {
            return true;
        }
        return false;
    }

}
