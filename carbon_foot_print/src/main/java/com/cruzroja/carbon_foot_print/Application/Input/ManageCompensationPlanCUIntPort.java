package com.cruzroja.carbon_foot_print.Application.Input;

import java.util.List;

import com.cruzroja.carbon_foot_print.Domain.Models.CompensationPlan;

public interface ManageCompensationPlanCUIntPort {
    public List<CompensationPlan> finAllCompensationPlan();

    public CompensationPlan saveCompensationPlan(CompensationPlan compensationPlan);

    public CompensationPlan updateCompensationPlan(CompensationPlan compensationPlan);

    public CompensationPlan updateWithPrice(CompensationPlan compensationPlan);

    public CompensationPlan findByCompensationPlanId(long planId);

    public CompensationPlan findByCompesationPlanName(String planName);
}
