package com.cruzroja.carbon_foot_print.Application.Input;

import java.util.List;

import com.cruzroja.carbon_foot_print.Domain.Models.Action;

public interface ManageActionCUIntPort {
    /**
     * Revisa que la información solicitada haya sido encontrada.
     * 
     * @return {@code List<Action>} en caso de que haya sido encontrada y
     *         {@code Error} en caso contrario.
     */
    public List<Action> findAllActions();

    /**
     * Revisa que los datos a guardar cumplan las reglas de negocio.
     * #Reglas de negocio:
     * 1. NO haya un dato previo con el mismo nombre del que se busca ingresar.
     * 
     * @param action item a guardar
     * @return {@code Action} item guardado o {@Error} en caso que se incumpla con
     *         una regla de negocio
     */
    public Action saveAction(Action action);

    /**
     * Revisa que los nuevos datos cumplan con las reglas de negocio para que se
     * actualicen.
     * 
     * @param action contiene el identificador del item a actualizar y la nueva
     *               información.
     * @return {@code Action} item guardado o {@Error} en caso que se incumpla con
     *         una regla de negocio.
     */
    public Action updateAction(Action action);

    /**
     * Revisa que la información solicitada haya sido encontrada.
     * 
     * @return {@code Action} en caso de que haya sido encontrada y
     *         {@code Error} en caso contrario.
     */
    public Action findActionById(long idAction);

    /**
     * Revisa que la información solicitada haya sido encontrada.
     * 
     * @param nameAction patrón de nombre a buscar
     * @return {@code Action} en caso de que haya sido encontrada y {@code Error} en
     *         caso contrario.
     */
    public Action findActionByName(String nameAction);
}
