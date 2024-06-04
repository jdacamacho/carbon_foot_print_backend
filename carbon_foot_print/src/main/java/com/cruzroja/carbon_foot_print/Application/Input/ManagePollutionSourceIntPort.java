package com.cruzroja.carbon_foot_print.Application.Input;

import java.util.List;

import com.cruzroja.carbon_foot_print.Domain.Models.PollutionSource;
import com.cruzroja.carbon_foot_print.Infrastucture.Output.Persistence.Serealizables.PollutionSourceId;

/**
 * Interfaz para la gestión de fuentes de contaminación.
 */
public interface ManagePollutionSourceIntPort {

    /**
     * Obtiene una lista de todas las fuentes de contaminacion.
     * 
     * Este método recupera todas las fuentes de contaminación disponibles en el sistema.
     * 
     * @return Una lista de todas las fuentes de contaminación disponibles.
     */
    public List<PollutionSource> listPollutionSources();

    /**
     * Obtiene una fuente de contaminación por su identificador único.
     * 
     * Este método busca una fuente de contaminación específica usando su ID único.
     * 
     * @param idPollution El identificador único de la contaminación.
     * @param idSource El identificador único de la fuente.
     * @return La fuente de contaminación encontrada, o null si no se encuentra una fuente con los IDs proporcionados.
     */
    public PollutionSource findById(long idPollution, long idSource);

    /**
     * Obtiene una lista de fuentes de contaminación por sus identificadores.
     * 
     * Este método busca múltiples fuentes de contaminación específicas usando una lista de IDs únicos.
     * 
     * @param idPollutionsSources Una lista de identificadores de fuentes de contaminación. No debe ser null.
     * @return Una lista de fuentes de contaminación encontradas, o una lista vacía si no se encuentran fuentes con los IDs proporcionados.
     */
    public List<PollutionSource> findAllById(List<PollutionSourceId> idPollutionsSources);
}
