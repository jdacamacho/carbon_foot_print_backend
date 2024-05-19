package com.cruzroja.carbon_foot_print.Domain.Models;

import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * Representa una categoría en el sistema, utilizada para clasificar elementos
 * según su propósito.
 */
@Data
@AllArgsConstructor
public class Category {

    /** Identificador único de la categoría. */
    private long categoryId;

    /** Nombre descriptivo de la categoría. */
    private String categoryName;

    /** Descripción detallada de la categoría. */
    private String categoryDescription;

    /** Ámbito o alcance de la categoría. */
    private String categoryScope;
    /**
     * Estado de la categoría [habilitado {@code true} deshabilitado {@code false}]
     */
    private boolean categoryState;
    /**
     * Lista de contaminantes asociados a la categoría.
     */
    private List<PollutionType> pollutions;

    public Category() {
        this.pollutions = new ArrayList<PollutionType>();
    }

    /**
     * Actualiza los datos de la categoría con los valores de otra categoría.
     * 
     * @param newCategory La nueva categoría con los datos actualizados.
     */
    public void update(Category newCategory) {
        this.categoryName = newCategory.getCategoryName();
        this.categoryDescription = newCategory.getCategoryDescription();
        this.categoryScope = newCategory.getCategoryScope();
        this.categoryState = (!this.pollutions.isEmpty() && newCategory.isCategoryState());
        this.pollutions = newCategory.getPollutions();
    }

    /**
     * Verifica si el ámbito proporcionado es válido.
     * 
     * @param newScope El nuevo ámbito a verificar.
     * @return true si el ámbito es válido, false de lo contrario.
     */
    public boolean isValidScope(String newScope) {
        List<String> validScopes = new ArrayList<String>();
        validScopes.add("Alcance 1");
        validScopes.add("Alcance 2");
        validScopes.add("Alcance 3");

        return validScopes.contains(newScope);
    }

    /**
     * Verifica si el nombre de la categoría se actualizó.
     * 
     * @param name El nuevo nombre a verificar.
     * @return true si el nombre se actualizó, false de lo contrario.
     */
    public boolean isUpdateName(String name) {
        return !this.categoryName.equals(name);
    }

    /**
     * Verifica si los tipos de contaminantes son validos.
     * 
     * @param valids {@code List<PollutionType>} lista de contaminantes válidos
     * @return {@code true} en caso de que todos sean válidos y {@code false} en
     *         caso de que almenos 1 sea invalido.
     */
    public boolean isValidPollution(List<PollutionType> valids) {
        return valids.containsAll(this.pollutions);
    }

    /**
     * Establece el status de la categoría, no puede habilitarse una categoría sin
     * contaminantes asociados.
     */
    public void determineStatus() {
        this.categoryState = !this.pollutions.isEmpty();
    }

}
