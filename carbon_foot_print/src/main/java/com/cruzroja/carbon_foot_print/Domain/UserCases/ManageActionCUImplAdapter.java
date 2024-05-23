package com.cruzroja.carbon_foot_print.Domain.UserCases;

import java.util.List;

import com.cruzroja.carbon_foot_print.Application.Input.ManageActionCUIntPort;
import com.cruzroja.carbon_foot_print.Application.Output.ExceptionFormatterIntPort;
import com.cruzroja.carbon_foot_print.Application.Output.ManageActionGatewayIntPort;
import com.cruzroja.carbon_foot_print.Domain.Models.Action;

public class ManageActionCUImplAdapter implements ManageActionCUIntPort {
    /** Puesta de enlace desde el dominio a los datos. */
    private final ManageActionGatewayIntPort gateway;
    /** Utlidad para manejo de excepciones personalizadas. */
    private final ExceptionFormatterIntPort exceptionFormatter;

    public ManageActionCUImplAdapter(ManageActionGatewayIntPort gateway,
            ExceptionFormatterIntPort exceptionFormatter) {
        this.gateway = gateway;
        this.exceptionFormatter = exceptionFormatter;
    }

    @Override
    public List<Action> findAllActions() {
        List<Action> actions = this.gateway.findAllActions();
        if (actions.size() == 0) {
            this.exceptionFormatter.returNoData("No actions in the System");
        }
        return actions;
    }

    @Override
    public Action saveAction(Action action) {
        Action objResponse = null;
        if(this.gateway.existsByName(action.getActionName())){
            this.exceptionFormatter.returnResponseErrorEntityExists("Action with that name already exists");
        }
        objResponse = this.gateway.saveAction(action);
        return objResponse;
    }

    @Override
    public Action updateAction(Action action) {
        Action objResponse = null;
        if (!this.gateway.existsById(action.getActionId())) {
            this.exceptionFormatter.returnResponseErrorEntityNotFound("Action was not found");
        } else {
            Action oldAction = this.findActionById(action.getActionId());
            if (this.gateway.existsByName(action.getActionName())) {
                if (!oldAction.isEqualName(action)) {
                    this.exceptionFormatter.returnResponseErrorEntityExists("Exists another action with that name");
                }
            }
            oldAction.update(action);
            objResponse = this.gateway.saveAction(oldAction);
        }
        return objResponse;
    }

    @Override
    public Action findActionById(long idAction) {
        Action objResponse = null;
        if (!this.gateway.existsById(idAction)) {
            this.exceptionFormatter.returnResponseErrorEntityNotFound("Action was not found with that id");
        }
        objResponse = this.gateway.findById(idAction);
        return objResponse;
    }

    @Override
    public Action findActionByName(String nameAction) {
        Action objResponse = null;
        if (!this.gateway.existsByName(nameAction)) {
            this.exceptionFormatter.returnResponseErrorEntityNotFound("Action was not found with that name");
        }
        objResponse = this.gateway.findByName(nameAction);
        return objResponse;
    }

}
