package com.cruzroja.carbon_foot_print.Application.Input;

import java.util.List;

import com.cruzroja.carbon_foot_print.Domain.CompansationPlan.CompensationMiddleWare;

public interface ManageCompensationActionCUIntPort {
    public List<CompensationMiddleWare> findAll();

    public CompensationMiddleWare findByPlanId(long plan);

    public CompensationMiddleWare findByPlanName(String name);

    public CompensationMiddleWare save(CompensationMiddleWare compensationMiddleWare);

    public CompensationMiddleWare update(CompensationMiddleWare compensationMiddleWare);
}
