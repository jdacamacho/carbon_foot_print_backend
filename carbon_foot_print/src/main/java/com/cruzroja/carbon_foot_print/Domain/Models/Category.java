package com.cruzroja.carbon_foot_print.Domain.Models;

import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * Representa una categoría en el sistema, utilizada para clasificar elementos según su propósito.
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
     * Actualiza los datos de la categoría con los valores de otra categoría.
     * 
     * @param newCategory La nueva categoría con los datos actualizados.
     */
    public void update(Category newCategory) {
        this.categoryName = newCategory.categoryName;
        this.categoryDescription = newCategory.categoryDescription;
        this.categoryScope = newCategory.categoryScope;
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
     * Crea una nueva instancia de Category.
     */
    public Category() {
    }
}
