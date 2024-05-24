package com.cruzroja.carbon_foot_print.Application.Input;

import java.util.List;

import com.cruzroja.carbon_foot_print.Domain.Models.Category;

/**
 * Interfaz para la gestión de categorías.
 */
public interface ManageCategoryCUIntPort {

    /**
     * Revisa que la información para crear una nueva categoría cumpla las reglas de
     * negocio.
     * #Reglas de negocio entrada:
     * 1. El Alcance (scope) debe estar en el dominio ("Alcance 1","Alcance
     * 2","Alcance 3"). Error code: {@code 406}
     * 2. Los contaminantes (pollution types) deben estar registrados en la base de
     * datos. Error code: {@code 404}
     * 3. El nombre no debe estar registrado previamente en la base de datos. Error
     * code: {@code 406}
     * 
     * @param category La categoría a crear.
     * @return La categoría creada.
     */
    Category create(Category category);

    /**
     * Revisa que la información a actualizar compa las reglas de negocio.
     * #Reglas de negocio entrada
     * 1. El Alcance (scope) debe estar en el dominio ("Alcance 1","Alcance
     * 2","Alcance 3"). Error code: {@code 406}
     * 2. Los contaminantes (pollution types) deben estar registrados en la base de
     * datos. Error code: {@code 404}
     * 3. El nombre no debe estar registrado previamente en la base de datos. Error
     * code: {@code 406}
     * 
     * @param category La categoría a actualizar.
     * @return La categoría actualizada.
     */
    Category update(Category category);

    /**
     * Revisa que la consulta cumpla con las reglas de negocio.
     * #Reglas de negocio salida
     * 1. Que la información se haya encontrado
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
