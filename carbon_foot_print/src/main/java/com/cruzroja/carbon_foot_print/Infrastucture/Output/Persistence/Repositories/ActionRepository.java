package com.cruzroja.carbon_foot_print.Infrastucture.Output.Persistence.Repositories;

import org.springframework.data.repository.CrudRepository;
import com.cruzroja.carbon_foot_print.Infrastucture.Output.Persistence.Entities.ActionEntity;

/** Repositorio para la gestión de entidades de acciones.*/
public interface ActionRepository extends CrudRepository<ActionEntity, Long> {

    /*Encuentra una entidad de acción por su nombre.
     * 
     * @param actionName El nombre de la acción a buscar.
     * @return La entidad de acción encontrada, o null si no se encuentra.
     */
    ActionEntity findByActionName(String actionName);

    /**
     * Verifica si existe una entidad de acción con el nombre especificado.
     * 
     * @param actionName El nombre de la acción a verificar.
     * @return true si existe una entidad de acción con el nombre especificado, false en caso contrario.
     */
    boolean existsByActionName(String actionName);
}
