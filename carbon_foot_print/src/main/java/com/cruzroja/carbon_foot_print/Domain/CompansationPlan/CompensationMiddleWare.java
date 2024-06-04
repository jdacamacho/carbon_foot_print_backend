package com.cruzroja.carbon_foot_print.Domain.CompansationPlan;

import java.util.List;
import java.util.stream.Collectors;
import java.util.ArrayList;

import com.cruzroja.carbon_foot_print.Domain.Models.CompensationPlan;
import com.cruzroja.carbon_foot_print.Domain.Models.Action;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CompensationMiddleWare {
    private CompensationPlan plan;
    private List<ActionWithAmount> actions;

    public CompensationMiddleWare() {
        this.actions = new ArrayList<>();
    }

    /**
     * Determina si hay acciones repetidas tomando como criterio el {@code id} de
     * las acciones.
     * 
     * @return {@code true} en caso de que encuentre elementos repetidos y
     *         {@code false} en caso contrario
     */
    public boolean hasDuplicates() {
        List<Long> data = actions.stream().map(awa -> awa.getAction().getActionId()).collect(Collectors.toList());
        return data.size() == actions.size();
    }

    /**
     * Determina si las acciones que se le asignan al plan de compensación son
     * válidas.
     * 
     * @param valids lista de acciones validas.
     * @return {@code true} en caso de que las acciones asignadas pertenescan a la
     *         lista de acciones válidas y {@code false} en caso contrario.
     */
    public boolean isValidActions(List<Action> valids) {
        List<Action> actual = actions.stream().map(ActionWithAmount::getAction).collect(Collectors.toList());
        return valids.containsAll(actual);
    }

    /**
     * Calcula el precio para el plan de acción sumando los
     * precios parciales de cada acción asignada y usando el descuento.
     */
    public void calculeFullPrice() {
        double price = 0;
        for (ActionWithAmount item : actions) {
            price += item.calculePrice();
        }
        this.plan.calculePrice(price);
    }

    public void calculeUfp() {
        double ufp = 0;
        for (ActionWithAmount item : actions) {
            ufp += item.calculeUfp();
        }
        this.plan.setPlanUfp(ufp);
    }

    public List<Long> removedActions(List<Action> oldActions) {
        List<Long> removed = new ArrayList<>();
        List<Action> actual = actions.stream().map(ActionWithAmount::getAction).collect(Collectors.toList());
        for (Action item : actual)
            if (!oldActions.contains(item))
                removed.add(item.getActionId());
        return removed;
    }

    public List<Action> getOnlyActions() {
        return actions.stream().map(ActionWithAmount::getAction).collect(Collectors.toList());
    }
}
