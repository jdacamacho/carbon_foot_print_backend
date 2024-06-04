package com.cruzroja.carbon_foot_print.Domain.CompansationPlan;

import com.cruzroja.carbon_foot_print.Domain.Models.Action;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ActionWithAmount {
    private Action action;
    private int amount;
    private double price;
    private double ufp;

    /**
     * Constructor publico para realizar los mapeos.
     */
    public ActionWithAmount() {
    }

    /**
     * Constructor parametrizado que asigna los valores ingresados y calcula el
     * precio a partir de estos.
     * 
     * @param action Acción seleccionada.
     * @param amount Cantidad de veces a realizar la acción.
     */
    public ActionWithAmount(Action action, int amount) {
        this.action = action;
        this.amount = amount;
        this.price = action.getActionUnitaryPrice() * amount;
        this.ufp = action.getActionUfp() * amount;
    }

    public double calculePrice() {
        this.price = this.action.getActionUnitaryPrice() * this.amount;
        return this.price;
    }

    public double calculeUfp() {
        this.ufp = this.action.getActionUfp() * this.amount;
        return this.price;
    }
}
