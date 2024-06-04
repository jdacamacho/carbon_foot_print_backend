package com.cruzroja.carbon_foot_print.Application.Output;

import java.util.List;

import com.cruzroja.carbon_foot_print.Domain.Models.Source;

/**
 * Interfaz para la gestión de fuentes.
 */
public interface ManageSourceGatewayIntPort {

    /**
     * Obtiene una lista de todas las fuentes.
     * 
     * Este método recupera todas las fuentes disponibles en el sistema.
     * 
     * @return Una lista de todas las fuentes disponibles.
     */
    public List<Source> findAll();

    /**
     * Guarda una nueva fuente.
     * 
     * Este método permite almacenar una nueva fuente en el sistema.
     * 
     * @param source La fuente a guardar. No debe ser null.
     * @return La fuente guardada, incluyendo cualquier información generada por el sistema (como un ID).
     */
    public Source save(Source source);

    /**
     * Obtiene una fuente por su identificador único.
     * 
     * Este método busca una fuente específica usando su ID único.
     * 
     * @param idSource El identificador único de la fuente a buscar.
     * @return La fuente encontrada, o null si no se encuentra una fuente con el ID proporcionado.
     */
    public Source findById(long idSource);

    /**
     * Verifica si una fuente existe por su identificador único.
     * 
     * Este método comprueba si una fuente con el ID proporcionado existe en el sistema.
     * 
     * @param idSource El identificador único de la fuente a verificar.
     * @return true si la fuente existe, false en caso contrario.
     */
    public boolean existsById(long idSource);

    /**
     * Obtiene una fuente por su nombre.
     * 
     * Este método busca una fuente específica usando su nombre.
     * 
     * @param sourceName El nombre de la fuente a buscar. No debe ser null.
     * @return La fuente encontrada, o null si no se encuentra una fuente con el nombre proporcionado.
     */
    public Source findByName(String sourceName);

    /**
     * Verifica si una fuente existe por su nombre.
     * 
     * Este método comprueba si una fuente con el nombre proporcionado existe en el sistema.
     * 
     * @param name El nombre de la fuente a verificar. No debe ser null.
     * @return true si la fuente existe, false en caso contrario.
     */
    public boolean existsByName(String name);
}
