package com.cruzroja.carbon_foot_print.Domain.UserCases;

import java.util.List;

import com.cruzroja.carbon_foot_print.Application.Input.ManageActionCUIntPort;
import com.cruzroja.carbon_foot_print.Application.Output.ExceptionFormatterIntPort;
import com.cruzroja.carbon_foot_print.Application.Output.ManageActionGatewayIntPort;
import com.cruzroja.carbon_foot_print.Domain.Models.Action;

/*Adaptador que implementa el puerto de entrada para gestionar acciones relacionadas con la huella de carbono.*/
public class ManageActionCUImplAdapter implements ManageActionCUIntPort {
    /** Puesta de enlace desde el dominio a los datos. */
    private final ManageActionGatewayIntPort gateway;
    /** Utilidad para manejo de excepciones personalizadas. */
    private final ExceptionFormatterIntPort exceptionFormatter;

    /**
     * Constructor de la clase ManageActionCUImplAdapter.
     *
     * @param gateway             Puesta de enlace desde el dominio a los datos.
     * @param exceptionFormatter Utilidad para manejo de excepciones personalizadas.
     */
    public ManageActionCUImplAdapter(ManageActionGatewayIntPort gateway,
                                      ExceptionFormatterIntPort exceptionFormatter) {
        this.gateway = gateway;
        this.exceptionFormatter = exceptionFormatter;
    }

    /**
     * Encuentra todas las acciones disponibles.
     *
     * @return Lista de objetos Action si se encuentran acciones, o lanza una excepción si no se encuentra ninguna.
     */
    @Override
    public List<Action> findAllActions() {
        List<Action> actions = this.gateway.findAllActions();
        if (actions.size() == 0) {
            this.exceptionFormatter.returNoData("No actions in the System");
        }
        return actions;
    }

    /**
     * Guarda una nueva acción si no existe otra con el mismo nombre.
     *
     * @param action La acción a ser guardada.
     * @return El objeto Action guardado, o lanza una excepción si ya existe una acción con el mismo nombre.
     */
    @Override
    public Action saveAction(Action action) {
        Action objResponse = null;
        if(this.gateway.existsByName(action.getActionName())){
            this.exceptionFormatter.returnResponseErrorEntityExists("Action with that name already exists");
        }
        objResponse = this.gateway.saveAction(action);
        return objResponse;
    }

    /**
     * Actualiza una acción existente si cumple con las reglas de negocio.
     *
     * @param action La acción con el identificador y la nueva información.
     * @return El objeto Action actualizado, o lanza una excepción si no se cumple alguna regla de negocio.
     */
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

    /**
     * Encuentra una acción por su identificador.
     *
     * @param idAction El identificador de la acción a buscar.
     * @return El objeto Action encontrado, o lanza una excepción si no se encuentra ninguna acción con ese identificador.
     */
    @Override
    public Action findActionById(long idAction) {
        Action objResponse = null;
        if (!this.gateway.existsById(idAction)) {
            this.exceptionFormatter.returnResponseErrorEntityNotFound("Action was not found with that id");
        }
        objResponse = this.gateway.findById(idAction);
        return objResponse;
    }

    /**
     * Encuentra una acción por su nombre.
     *
     * @param nameAction El nombre de la acción a buscar.
     * @return El objeto Action encontrado, o lanza una excepción si no se encuentra ninguna acción con ese nombre.
     */
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

