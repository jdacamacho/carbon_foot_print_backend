package com.cruzroja.carbon_foot_print.Application.Input;

import java.util.List;

import com.cruzroja.carbon_foot_print.Domain.Models.Category;

/**
 * Interfaz para la gestión de categorías.
 */
public interface ManageCategoryCUIntPort {
    
    /**
     * Crea una nueva categoría.
     * 
     * @param category La categoría a crear.
     * @return La categoría creada.
     */
    Category create(Category category);

    /**
     * Actualiza una categoría existente.
     * 
     * @param category La categoría a actualizar.
     * @return La categoría actualizada.
     */
    Category update(Category category);

    /**
     * Encuentra una categoría por su identificador único.
     * 
     * @param id El identificador único de la categoría.
     * @return La categoría encontrada, o null si no se encuentra.
     */
    Category findById(long id);

    /**
     * Obtiene todas las categorías.
     * 
     * @return Una lista de todas las categorías.
     */
    List<Category> findAll();

    /**
     * Encuentra categorías por su nombre.
     * 
     * @param name El nombre de la categoría a buscar.
     * @return Una lista de categorías que coinciden con el nombre especificado.
     */
    List<Category> findByName(String name);

}
