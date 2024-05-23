package com.cruzroja.carbon_foot_print.Application.Output;

import java.util.List;

import com.cruzroja.carbon_foot_print.Domain.Models.Action;
import com.cruzroja.carbon_foot_print.Domain.Models.CompensationPlan;

public interface ManageCompensationPlanGatewayIntPort {
    public List<CompensationPlan> findAll();
    public CompensationPlan save(CompensationPlan compensationPlan);
    public CompensationPlan findById(long planId);
    public CompensationPlan findByName(String planName);
    public boolean existsById(long planId);
    public boolean existsByName(String planName);
    public List<Action> findAllActions();
}