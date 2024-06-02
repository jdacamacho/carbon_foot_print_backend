package com.cruzroja.carbon_foot_print.Infrastucture.Output.Persistence.Gateway;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.stereotype.Service;

import com.cruzroja.carbon_foot_print.Application.Output.ManageCompensationActionGatewayIntPort;
import com.cruzroja.carbon_foot_print.Domain.Models.Action;
import com.cruzroja.carbon_foot_print.Domain.Models.CompensationAction;
import com.cruzroja.carbon_foot_print.Infrastucture.Output.Persistence.Entities.ActionEntity;
import com.cruzroja.carbon_foot_print.Infrastucture.Output.Persistence.Entities.CompensationActionEntity;
import com.cruzroja.carbon_foot_print.Infrastucture.Output.Persistence.Repositories.CompensationActionRepository;
import com.cruzroja.carbon_foot_print.Infrastucture.Output.Persistence.Serealizables.CompensationActionId;

@Service
public class ManageCompensationActionGatewayImplAdapter implements ManageCompensationActionGatewayIntPort {
    private final CompensationActionRepository serviceBD;
    private final ModelMapper mapper;

    public ManageCompensationActionGatewayImplAdapter(CompensationActionRepository serviceBD,
            ModelMapper mapper) {
        this.serviceBD = serviceBD;
        this.mapper = mapper;
    }

    @Override
    public List<CompensationAction> findAll() {
        Iterable<CompensationActionEntity> dataDB = this.serviceBD.findAll();
        List<CompensationAction> response = this.mapper.map(dataDB, new TypeToken<List<CompensationAction>>() {
        }.getType());
        return response;
    }

    @Override
    public List<CompensationAction> findById(long planId) {
        List<CompensationActionEntity> dataDB = this.serviceBD.findByPlanPlanId(planId);
        List<CompensationAction> response = this.mapper.map(dataDB, new TypeToken<List<CompensationAction>>() {
        }.getType());
        return response;
    }

    @Override
    public List<CompensationAction> findByName(String name) {
        List<CompensationActionEntity> dataDB = this.serviceBD.findByPlanPlanName(name);
        List<CompensationAction> response = this.mapper.map(dataDB, new TypeToken<List<CompensationAction>>() {
        }.getType());
        return response;
    }

    @Override
    public List<Action> findValidActions() {
        List<ActionEntity> dataFromBD = this.serviceBD.findAllActions();
        List<Action> actions = this.mapper.map(dataFromBD, new TypeToken<List<Action>>() {
        }.getType());
        return actions;
    }

    @Override
    public List<CompensationAction> save(List<CompensationAction> compensationActions) {
        List<CompensationActionEntity> toSave = this.mapper.map(compensationActions,
                new TypeToken<List<CompensationActionEntity>>() {
                }.getType());

        Iterable<CompensationActionEntity> dataDB = this.serviceBD.saveAll(toSave);
        List<CompensationAction> response = this.mapper.map(dataDB, new TypeToken<List<CompensationAction>>() {
        }.getType());
        return response;
    }

    @Override
    public void delete(long planId, long actionId) {
        CompensationActionId id = new CompensationActionId(actionId, planId);
        this.serviceBD.deleteById(id);
    }

    @Override
    public void delete(long planId, List<Long> actionsId) {
        List<CompensationActionId> ids = new ArrayList<>();
        actionsId.forEach(action -> {
            ids.add(new CompensationActionId(action, planId));
        });
        this.serviceBD.deleteAllById(ids);
    }

}
