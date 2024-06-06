package com.cruzroja.carbon_foot_print.Infrastucture.Output.Persistence.Repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import com.cruzroja.carbon_foot_print.Infrastucture.Output.Persistence.Entities.PollutionTypeEntity;
import com.cruzroja.carbon_foot_print.Infrastucture.Output.Persistence.Entities.SourceEntity;

/**Repositorio para la gestión de entidades de tipos de contaminación.*/
public interface PollutionTypeRepository extends CrudRepository<PollutionTypeEntity, Long> {

    /**
     * Verifica si existe una entidad de tipo de contaminación con el nombre especificado.
     * 
     * @param name El nombre del tipo de contaminación a verificar.
     * @return true si existe una entidad de tipo de contaminación con el nombre especificado, false en caso contrario.
     */
    boolean existsByPollutionTypeName(String name);

    /**
     * Encuentra entidades de tipo de contaminación por su nombre.
     * 
     * @param name El nombre del tipo de contaminación a buscar.
     * @return Una lista de entidades de tipo de contaminación que coinciden con el nombre especificado.
     */
    List<PollutionTypeEntity> findByPollutionTypeName(String name);

    /**
     * Obtiene todas las entidades de fuente.
     * 
     * @return Una lista de todas las entidades de fuente.
     */
    @Query("from SourceEntity")
    List<SourceEntity> findAllSources();
}
