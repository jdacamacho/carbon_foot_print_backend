package com.cruzroja.carbon_foot_print.Domain.Models;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * Clase que representa una acción dentro del sistema de huella de carbono.
 */
@Data
@AllArgsConstructor
public class Action {
    /** Identificador único de la acción. */
    private long actionId;

    /** Nombre de la acción. */
    private String actionName;

    /** Descripción de la acción. */
    private String actionDescription;

    /* Precio unitario de la acción. */
    private double actionUnitaryPrice;
    /* Unidades de huella de carbono compensadas. */
    private double actionUfp;

    /* Constructor por defecto. */
    public Action() {
        // Constructor vacío
    }

    /**
     * Compara el nombre de esta acción con el nombre de otra acción.
     * 
     * @param action La acción con la que comparar.
     * @return true si los nombres de las acciones son iguales, false en caso
     *         contrario.
     */
    public boolean isEqualName(Action action) {
        return this.actionName.equals(action.getActionName());
    }

    /**
     * Actualiza los detalles de esta acción con los detalles de otra acción.
     * 
     * @param action La acción con los nuevos detalles para actualizar.
     */
    public void update(Action action) {
        this.setActionName(action.getActionName());
        this.setActionDescription(action.getActionDescription());
        this.setActionUnitaryPrice(action.getActionUnitaryPrice());
        this.actionUfp = action.getActionUfp();
    }
}
