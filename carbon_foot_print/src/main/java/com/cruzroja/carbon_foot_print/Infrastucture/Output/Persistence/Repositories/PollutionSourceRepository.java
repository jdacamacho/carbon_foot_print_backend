package com.cruzroja.carbon_foot_print.Infrastucture.Output.Persistence.Repositories;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.cruzroja.carbon_foot_print.Infrastucture.Output.Persistence.Entities.PollutionSourceEntity;
import com.cruzroja.carbon_foot_print.Infrastucture.Output.Persistence.Serealizables.PollutionSourceId;

/**
 * Repositorio para la gestión de entidades de fuentes de contaminación.
 */
public interface PollutionSourceRepository extends CrudRepository<PollutionSourceEntity, PollutionSourceId> {

    /**
     * Encuentra una entidad de fuente de contaminación por su identificador compuesto.
     * 
     * @param id El identificador compuesto de la fuente de contaminación.
     * @return Un Optional que contiene la entidad de fuente de contaminación encontrada, o vacío si no se encuentra.
     */
    Optional<PollutionSourceEntity> findById(PollutionSourceId id);
}
