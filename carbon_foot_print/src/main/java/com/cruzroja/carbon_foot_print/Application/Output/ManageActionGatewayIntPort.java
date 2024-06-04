package com.cruzroja.carbon_foot_print.Application.Output;

import java.util.List;

import com.cruzroja.carbon_foot_print.Domain.Models.Action;

/**
 * Interfaz para la gestión de acciones.
 */
public interface ManageActionGatewayIntPort {

    /**
     * Obtiene una lista de todas las acciones.
     * 
     * Este método recupera todas las acciones disponibles en el sistema.
     * 
     * @return Una lista de todas las acciones disponibles.
     */
    public List<Action> findAllActions();

    /**
     * Guarda una nueva acción.
     * 
     * Este método permite almacenar una nueva acción en el sistema.
     * 
     * @param action La acción a guardar. No debe ser null.
     * @return La acción guardada, incluyendo cualquier información generada por el sistema (como un ID).
     */
    public Action saveAction(Action action);

    /**
     * Obtiene una acción por su identificador único.
     * 
     * Este método busca una acción específica usando su ID único.
     * 
     * @param idAction El identificador único de la acción a buscar.
     * @return La acción encontrada, o null si no se encuentra una acción con el ID proporcionado.
     */
    public Action findById(long idAction);

    /**
     * Obtiene una acción por su nombre.
     * 
     * Este método busca una acción específica usando su nombre.
     * 
     * @param nameAction El nombre de la acción a buscar. No debe ser null.
     * @return La acción encontrada, o null si no se encuentra una acción con el nombre proporcionado.
     */
    public Action findByName(String nameAction);

    /**
     * Verifica si una acción existe por su identificador único.
     * 
     * Este método comprueba si una acción con el ID proporcionado existe en el sistema.
     * 
     * @param idAction El identificador único de la acción a verificar.
     * @return true si la acción existe, false en caso contrario.
     */
    public boolean existsById(long idAction);

    /**
     * Verifica si una accion existe por su nombre.
     * 
     * Este método comprueba si una acción con el nombre proporcionado existe en el sistema.
     * 
     * @param nameAction El nombre de la acción a verificar. No debe ser null.
     * @return true si la acción existe, false en caso contrario.
     */
    public boolean existsByName(String nameAction);
}
