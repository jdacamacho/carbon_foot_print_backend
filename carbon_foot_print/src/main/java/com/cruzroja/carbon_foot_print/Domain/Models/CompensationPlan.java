package com.cruzroja.carbon_foot_print.Domain.Models;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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

    public void calculatePrice(){
        double priceActions = 0;
        double newPrice = 0;
        this.setPlanPrice(0);
        for(int i = 0 ; i < this.actions.size() ; i++){
            priceActions = priceActions + this.actions.get(i).getActionUnitaryPrice();
        }
        newPrice = priceActions - (priceActions*(this.planDiscount/100));
        this.setPlanPrice(newPrice);
    }

    public boolean isPlanNameEqual(CompensationPlan compensationPlan){
        return this.planName.equals(compensationPlan.getPlanName());
    }

    public void update(CompensationPlan compensationPlan){
        this.setPlanName(compensationPlan.getPlanName());
        this.setPlanDescription(compensationPlan.getPlanDescription());
        this.setActions(compensationPlan.getActions());
        this.setPlanDiscount(compensationPlan.getPlanDiscount());
        this.calculatePrice();
    }

    public boolean isValidDiscount(){
        int discount = this.getPlanDiscount(); 
        if(discount >= 0 && discount <= 100){
            return true;
        }
        return false;
    }

    public boolean isValidActions(List<Action> validActions){
        List<Action> actions = this.getActions();
        int wasFound = 0;
        for (Action action : actions) {
            for (Action validAction : validActions) {
                if(action.equals(validAction)) wasFound ++;
            }
        }
        return actions.size() == wasFound;
    } 

    public boolean hasDuplicateAction(){
        Set<Action> actionSet = new HashSet<>(this.getActions());
        return actionSet.size() < this.getActions().size();
    }

}
