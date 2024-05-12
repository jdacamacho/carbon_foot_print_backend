package com.cruzroja.carbon_foot_print.Infrastucture.Output.Persistence.Repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.cruzroja.carbon_foot_print.Infrastucture.Output.Persistence.Entities.CategoryEntity;
import com.cruzroja.carbon_foot_print.Infrastucture.Output.Persistence.Entities.PollutionTypeEntity;

/**
 * Interfaz que define los métodos para interactuar con la persistencia de las
 * categorías en la base de datos.
 */
public interface CategoryRepository extends CrudRepository<CategoryEntity, Long> {

    /**
     * Verifica si existe una categoría cuyo nombre sea similar al proporcionado.
     * 
     * @param categoryName El nombre de la categoría a buscar.
     * @return true si existe una categoría con un nombre similar, false de lo
     *         contrario.
     */
    boolean existsByCategoryNameLike(String categoryName);

    /**
     * Busca y devuelve una lista de categorías cuyo nombre sea similar al
     * proporcionado.
     * 
     * @param categoryName El nombre de la categoría a buscar.
     * @return Una lista de categorías con nombres similares.
     */
    List<CategoryEntity> findByCategoryNameLike(String categoryName);

    /**
     * Busca y devuelve una lista de todas las categorias
     * que se encuentren activas.
     * 
     * @return {@code List<CategoryEntity>}
     */
    List<CategoryEntity> findByCategoryStateIsTrue();

    /**
     * Busca a partir de una lista de ids y devuelve las categorías asociadas.
     * 
     * @param ids {@code List<Long>} lista de ids a buscar
     * @return {@code List<CategoryEntity>} lista de categorías que cumplen.
     */
    List<CategoryEntity> findByCategoryIdIn(List<Long> ids);

    /**
     * Busca a partir de una lista de ids y devuelve las categorías que estan
     * habilitadas dentro de los ids ingresados.
     * 
     * @param ids {@code List<Long>} lista de ids a buscar
     * @return {@code List<CategoryEntity>} lista de categorías que cumplen.
     */
    List<CategoryEntity> findByCategoryStateIsTrueAndCategoryIdIn(List<Long> ids);

    /**
     * Busca y devuelve todos los pollution types registrados en el sistema
     * 
     * @return {@code List<PollutionTypeEntity>} lista de pollution types
     */
    @Query("from PollutionTypeEntity")
    List<PollutionTypeEntity> findAllPollutionTypes();

}
