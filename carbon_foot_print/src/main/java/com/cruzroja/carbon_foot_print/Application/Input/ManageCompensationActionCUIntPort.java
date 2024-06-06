package com.cruzroja.carbon_foot_print.Application.Input;

import java.util.List;

import com.cruzroja.carbon_foot_print.Domain.CompansationPlan.CompensationMiddleWare;
import com.cruzroja.carbon_foot_print.Infrastucture.Output.ExceptionHandler.OwnException.BadFormatException;
import com.cruzroja.carbon_foot_print.Infrastucture.Output.ExceptionHandler.OwnException.BusinessRuleException;
import com.cruzroja.carbon_foot_print.Infrastucture.Output.ExceptionHandler.OwnException.EntityNotFoundException;

public interface ManageCompensationActionCUIntPort {
    /**
     * Revisa que la información solicitada haya sido encontrada.
     * #Reglas de negocio salida
     * 1. Que la información recuperada no este vacía {@code 404}.
     * 
     * @return Lista de planes de acción existentes.
     * @throws EntityNotFoundException Si no hay planes registrados.
     */
    public List<CompensationMiddleWare> findAll();

    /**
     * Revisa que la información solicitada haya sido encontrada.
     * #Reglas de negocio salida
     * 1. Que la información recuperada no este vacía {@code 404}.
     * 
     * @param plan identificador del plan a buscar.
     * @return {@code CompensationMiddleWare} item encontrado o {@code Error} en
     *         caso contrario.
     * @throws EntityNotFoundException Si no hay planes registrados con el
     *                                 identificador proporcionado.
     */
    public CompensationMiddleWare findByPlanId(long plan);

    /**
     * Revisa que la información solicitada haya sido encontrada.
     * #Reglas de negocio salida
     * 1. Que la información recuperada no este vacía {@code 404}.
     * 
     * @param name nombre del plan buscado.
     * @return {@code CompensationMiddleWare} item encontrado o {@code Error} en
     *         caso contrario.
     * @throws EntityNotFoundException Si no hay planes registrados con el
     *                                 identificador proporcionado.
     */
    public CompensationMiddleWare findByPlanName(String name);

    /**
     * Revisa que la información solicitada haya sido encontrada.
     * Información: planes por defecto.
     * #Reglas de negocio salida
     * 1. Que la información recuperada no este vacía {@code 404}.
     * 
     * @return {@code List<CompensationMiddleWare>} items encontrados o
     *         {@code Error} en
     *         caso contrario.
     * @throws EntityNotFoundException Si no hay planes registrados con el
     *                                 identificador proporcionado.
     */
    public List<CompensationMiddleWare> findDefault();

    /**
     * Verifica que la información haya sido encontrada y que el criterio de
     * búsqueda cumpla las reglas de negocio.
     * #Reglas de negocio entrada
     * 1. Que el id del voluntario exista. {@code 406}
     * #Reglas de negocio salida
     * 1. Que la información recuperada no este vacía {@code 404}.
     * 
     * @param volunteer
     * @return {@code List<CompensationMiddleWare>} items encontrados o
     *         {@code Error} en
     *         caso contrario.
     * @throws EntityNotFoundException Si no hay planes registrados con el
     *                                 identificador proporcionado.
     */
    public List<CompensationMiddleWare> findByVolunteer(long volunteer);

    /**
     * Verifica que los datos a guardar cumplan con las reglas de negocio.
     * #Reglas de negocio entrada
     * 1. Las acciones seleccionadas se encuentran registradas en el sistema
     * {@code 406}.
     * 2. Reglas de negocio de
     * {@code ManageCompensationPlanCUIntPort.saveCompensationPlan()}
     * 
     * @param compensationMiddleWare item a guardar.
     * @param isDefault              determina si es un plan personalizado o por
     *                               defecto.
     * @param volunteerId            id del voluntario que crea el plan.
     * @return {@code CompensationMiddleWare} item guardado o {@code Error} en caso
     *         de que se incumpla alguna regla de negocio.
     * @throws BusinessRuleException Si se incumple alguna regla de negocio.
     * @throws BadFormatException    Si el formato del plan de compensación es
     *                               incorrecto.
     */
    public CompensationMiddleWare save(CompensationMiddleWare compensationMiddleWare, boolean isDefault,
            long volunteerId);

    /**
     * Verifica que los datos a actualizar cumplan con las reglas de negocio.
     * #Reglas de negocio entrada
     * 1. Las acciones seleccionadas se encuentran registradas en el sistema
     * {@code 406}.
     * 2. Reglas de negocio de
     * {@code ManageCompensationPlanCUIntPort.saveCompensationPlan()}
     * 
     * @param compensationMiddleWare item con el id del item a actualizar y la
     *                               información a guardar.
     * @param volunteerId            id del voluntario que actualiza el plan.
     * @return {@code CompensationMiddleWare} item guardado o {@code Error} en caso
     *         de que se incumpla alguna regla de negocio.
     * @throws BusinessRuleException Si se incumple alguna regla de negocio.
     * @throws BadFormatException    Si el formato del plan de compensación es
     *                               incorrecto.
     */
    public CompensationMiddleWare update(CompensationMiddleWare compensationMiddleWare, long volunteerId);
}
