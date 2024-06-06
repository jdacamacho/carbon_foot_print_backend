/**
 * @file CompensationPlan.java
 * @brief Clase que representa un plan de compensación en el dominio del modelo.
 */

package com.cruzroja.carbon_foot_print.Domain.Models;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @class CompensationPlan
 * @brief Clase que representa un plan de compensación.
 *
 *        Esta clase incluye los atributos y métodos necesarios para gestionar
 *        un plan de compensación.
 */
@Data
@AllArgsConstructor
public class CompensationPlan {
    /** @brief Identificador único del plan. */
    private long planId;

    /** @brief Nombre del plan. */
    private String planName;

    /** @brief Precio del plan. */
    private double planPrice;

    /** @brief Descripción del plan. */
    private String planDescription;

    /** @brief Descuento aplicado al plan. */
    private double planDiscount;

    /* @brief Unidades de huella de carbono que compensa el plan */
    private double planUfp;

    /* @brief Plan por defecto o personalizado */
    private boolean planDefault;

    /* @brief Usuario voluntario que crea el plan */
    private UserVolunteer volunteer;

    /**
     * @brief Constructor por defecto.
     *
     *        Inicializa el precio en 0.
     */
    public CompensationPlan() {
        this.planPrice = 0;
        this.planUfp = 0;
    }

    public void calculatePrice(List<Double> prices) {
        double priceActions = 0;
        double newPrice = 0;
        this.setPlanPrice(0);
        for (int i = 0; i < prices.size(); i++) {
            priceActions += prices.get(i);
        }
        newPrice = priceActions - (priceActions * (this.planDiscount / 100));
        this.setPlanPrice(newPrice);
    }

    /**
     * @brief Compara el nombre del plan actual con el nombre de otro plan.
     *
     * @param compensationPlan El plan de compensación a comparar.
     * @return true si los nombres de los planes son iguales, false en caso
     *         contrario.
     */
    public boolean isPlanNameEqual(CompensationPlan compensationPlan) {
        return this.planName.equals(compensationPlan.getPlanName());
    }

    public void update(CompensationPlan compensationPlan, List<Double> prices) {
        this.setPlanName(compensationPlan.getPlanName());
        this.setPlanDescription(compensationPlan.getPlanDescription());
        this.setPlanDiscount(compensationPlan.getPlanDiscount());
        this.calculatePrice(prices);
    }

    /**
     * @brief Actualiza los atributos del plan actual con los atributos de otro
     *        plan.
     *
     * @param compensationPlan El plan de compensación con los nuevos valores.
     */
    public void update(CompensationPlan compensationPlan) {
        this.setPlanName(compensationPlan.getPlanName());
        this.setPlanDescription(compensationPlan.getPlanDescription());
        this.setPlanDiscount(compensationPlan.getPlanDiscount());
    }

    public void updateWithPrice(CompensationPlan compensationPlan) {
        this.setPlanName(compensationPlan.getPlanName());
        this.setPlanDescription(compensationPlan.getPlanDescription());
        this.setPlanDiscount(compensationPlan.getPlanDiscount());
        this.planUfp = compensationPlan.getPlanUfp();
        this.planPrice = compensationPlan.getPlanPrice();
        this.volunteer = compensationPlan.getVolunteer();
    }

    /**
     * @brief Verifica si el descuento del plan es válido.
     *
     *        Un descuento es válido si está entre 0 y 100 inclusive.
     * 
     * @return true si el descuento es válido, false en caso contrario.
     */
    public boolean isValidDiscount() {
        double discount = this.getPlanDiscount();
        if (discount >= 0 && discount <= 100) {
            return true;
        }
        return false;
    }

    public void calculePrice(double price) {
        this.planPrice = (1 - (this.planDiscount / 100)) * price;
    }

}
