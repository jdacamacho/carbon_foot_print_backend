package com.cruzroja.carbon_foot_print.Infrastucture.Output.Persistence.Repositories;

import org.springframework.data.repository.CrudRepository;
import com.cruzroja.carbon_foot_print.Infrastucture.Output.Persistence.Entities.SourceEntity;

/*Repositorio para la gestión de entidades de fuente.*/
public interface SourceRepository extends CrudRepository<SourceEntity, Long> {

    /**
     * Verifica si existe fuente con el nombre especificado.
     * 
     * @param sourceName El nombre de la fuente a verificar.
     * @return true si existe una entidad de fuente con el nombre especificado, false en caso contrario.
     */
    boolean existsBySourceName(String sourceName);

    /**
     * Encuentra una fuente por su nombre.
     * 
     * @param sourceName El nombre de la fuente a buscar.
     * @return La entidad de fuente encontrada, o null si no se encuentra.
     */
    SourceEntity findBySourceName(String sourceName);
}
