package com.cruzroja.carbon_foot_print.Domain.Models;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CompensationAction {
    private Action action;
    private CompensationPlan plan;
    private int compensationActionAmount;
    private double compensationActionPrice;
    private double compensationActionUfp;

    public CompensationAction() {
    }

    public CompensationAction(Action action, CompensationPlan plan, int compensationActionAmount) {
        this.action = action;
        this.plan = plan;
        this.compensationActionAmount = compensationActionAmount;
        this.calculePrice();
        this.calculeUfp();
    }

    public void calculePrice() {
        this.compensationActionPrice = this.compensationActionAmount * action.getActionUnitaryPrice();
    }

    public void calculeUfp() {
        this.compensationActionUfp = this.compensationActionAmount * action.getActionUfp();
    }
}
