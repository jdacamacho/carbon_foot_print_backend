package com.cruzroja.carbon_foot_print.Infrastucture.Output.Persistence.Gateway;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.stereotype.Service;

import com.cruzroja.carbon_foot_print.Application.Output.ManageActionGatewayIntPort;
import com.cruzroja.carbon_foot_print.Domain.Models.Action;
import com.cruzroja.carbon_foot_print.Infrastucture.Output.Persistence.Entities.ActionEntity;
import com.cruzroja.carbon_foot_print.Infrastucture.Output.Persistence.Repositories.ActionRepository;

@Service
public class ManageActionGatewayImpAdapter implements ManageActionGatewayIntPort{

    private final ActionRepository serviceBD;
    private final ModelMapper mapper;

    public ManageActionGatewayImpAdapter(ActionRepository serviceBD,
                                        ModelMapper mapper){
        this.serviceBD = serviceBD;
        this.mapper = mapper;
    }

    @Override
    public List<Action> findAllActions() {
        Iterable<ActionEntity> dataFromBD = this.serviceBD.findAll();
        List<Action> response = this.mapper.map(dataFromBD, new TypeToken<List<Action>>(){}.getType());
        return response;
    }

    @Override
    public Action saveAction(Action action) {
        ActionEntity actionToSave = this.mapper.map(action, ActionEntity.class);
        ActionEntity actionSaved = this.serviceBD.save(actionToSave);
        Action response = this.mapper.map(actionSaved, Action.class);
        return response;
    }

    @Override
    public Action findById(long idAction) {
        ActionEntity dataFromBD = this.serviceBD.findById(idAction).get();
        Action response = this.mapper.map(dataFromBD, Action.class);
        return response;
    }

    @Override
    public Action findByName(String nameAction) {
        ActionEntity dataFromBD = this.serviceBD.findByActionName(nameAction);
        Action response = this.mapper.map(dataFromBD, Action.class);
        return response;
    }

    @Override
    public boolean existsById(long idAction) {
        return this.serviceBD.existsById(idAction);
    }

    @Override
    public boolean existsByName(String nameAction) {
        return this.serviceBD.existsByActionName(nameAction);
    }
    
    
}
