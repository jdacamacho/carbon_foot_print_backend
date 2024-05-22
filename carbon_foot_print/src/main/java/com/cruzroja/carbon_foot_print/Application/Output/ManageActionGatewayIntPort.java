package com.cruzroja.carbon_foot_print.Application.Output;

import java.util.List;

import com.cruzroja.carbon_foot_print.Domain.Models.Action;

public interface ManageActionGatewayIntPort {
    public List<Action> findAllActions();
    public Action saveAction(Action action);
    public Action findById(long idAction);
    public Action findByName(String nameAction);
    public boolean existsById(long idAction);
    public boolean existsByName(String nameAction);
}
