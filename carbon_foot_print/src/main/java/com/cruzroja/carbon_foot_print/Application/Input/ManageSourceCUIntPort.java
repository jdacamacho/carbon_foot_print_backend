package com.cruzroja.carbon_foot_print.Application.Input;

import java.util.List;

import com.cruzroja.carbon_foot_print.Domain.Models.Source;

/**
 * Interfaz para la gestión de fuentes.
 */
public interface ManageSourceCUIntPort {

    /**
     * Obtiene una lista de todas las fuentes.
     * 
     * @return Una lista de todas las fuentes.
     */
    List<Source> listSources();

    /**
     * Guarda una nueva fuente.
     * 
     * @param source La fuente a guardar.
     * @return La fuente guardada.
     */
    Source saveSource(Source source);

    /**
     * Actualiza una fuente existente.
     * 
     * @param source La fuente a actualizar.
     * @return La fuente actualizada.
     */
    Source updateSource(Source source);

    /**
     * Obtiene una fuente por su identificador único.
     * 
     * @param idSource El identificador único de la fuente.
     * @return La fuente encontrada, o null si no se encuentra.
     */
    Source findByIdSource(long idSource);

    /**
     * Obtiene una fuente por su nombre.
     * 
     * @param sourceName El nombre de la fuente a buscar.
     * @return La fuente encontrada, o null si no se encuentra.
     */
    Source findBySourceName(String sourceName);
}

