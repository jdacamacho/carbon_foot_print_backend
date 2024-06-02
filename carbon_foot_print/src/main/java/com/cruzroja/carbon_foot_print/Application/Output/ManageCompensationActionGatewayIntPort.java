package com.cruzroja.carbon_foot_print.Application.Output;

import java.util.List;

import com.cruzroja.carbon_foot_print.Domain.Models.Action;
import com.cruzroja.carbon_foot_print.Domain.Models.CompensationAction;

public interface ManageCompensationActionGatewayIntPort {
    public List<CompensationAction> findAll();

    public List<CompensationAction> findById(long planId);

    public List<CompensationAction> findByName(String name);

    public List<Action> findValidActions();

    public List<CompensationAction> save(List<CompensationAction> compensationActions);

    public CompensationAction update(CompensationAction compensationActions);

    public List<CompensationAction> update(List<CompensationAction> compensationActions);

    public void delete(long planId, long actionId);

    public void delete(long planId, List<Long> actionsId);
}
