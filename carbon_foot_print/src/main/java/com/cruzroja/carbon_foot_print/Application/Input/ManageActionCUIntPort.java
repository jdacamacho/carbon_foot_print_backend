package com.cruzroja.carbon_foot_print.Application.Input;

import java.util.List;

import com.cruzroja.carbon_foot_print.Domain.Models.Action;

public interface ManageActionCUIntPort {
    public List<Action> findAllActions();
    public Action saveAction(Action action);
    public Action updateAction(Action action);
    public Action findActionById(long idAction);
    public Action findActionByName(String nameAction);
}
