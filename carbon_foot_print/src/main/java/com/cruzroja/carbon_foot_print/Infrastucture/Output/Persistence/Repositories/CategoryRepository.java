package com.cruzroja.carbon_foot_print.Infrastucture.Output.Persistence.Repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.cruzroja.carbon_foot_print.Infrastucture.Output.Persistence.Entities.CategoryEntity;

/**
 * Interfaz que define los métodos para interactuar con la persistencia de las categorías en la base de datos.
 */
public interface CategoryRepository extends CrudRepository<CategoryEntity, Long> {

    /**
     * Verifica si existe una categoría cuyo nombre sea similar al proporcionado.
     * 
     * @param categoryName El nombre de la categoría a buscar.
     * @return true si existe una categoría con un nombre similar, false de lo contrario.
     */
    boolean existsByCategoryNameLike(String categoryName);

    /**
     * Busca y devuelve una lista de categorías cuyo nombre sea similar al proporcionado.
     * 
     * @param categoryName El nombre de la categoría a buscar.
     * @return Una lista de categorías con nombres similares.
     */
    List<CategoryEntity> findByCategoryNameLike(String categoryName);

}
