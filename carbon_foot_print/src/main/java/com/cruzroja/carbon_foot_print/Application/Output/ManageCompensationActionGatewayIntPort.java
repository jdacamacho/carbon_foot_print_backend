package com.cruzroja.carbon_foot_print.Application.Output;

import java.util.List;

import com.cruzroja.carbon_foot_print.Domain.Models.Action;
import com.cruzroja.carbon_foot_print.Domain.Models.CompensationAction;
import com.cruzroja.carbon_foot_print.Domain.Models.UserVolunteer;

public interface ManageCompensationActionGatewayIntPort {
    public List<CompensationAction> findAll();

    public List<CompensationAction> findById(long planId);

    public List<CompensationAction> findByVolunteerId(long volunterId);

    public List<CompensationAction> findByName(String name);

    public List<CompensationAction> findDefault();

    public List<Action> findValidActions();

    public UserVolunteer findVolunteerById(long volunteerId);

    public List<CompensationAction> save(List<CompensationAction> compensationActions);

    public void delete(long planId, long actionId);

    public void delete(long planId, List<Long> actionsId);
}
