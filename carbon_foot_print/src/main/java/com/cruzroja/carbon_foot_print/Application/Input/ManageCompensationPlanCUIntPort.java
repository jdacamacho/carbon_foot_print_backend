/**
 * @file ManageCompensationPlanCUIntPort.java
 * @brief Interfaz para la gestión de planes de compensación en la aplicación.
 */

package com.cruzroja.carbon_foot_print.Application.Input;

import java.util.List;
import com.cruzroja.carbon_foot_print.Domain.Models.CompensationPlan;
import com.cruzroja.carbon_foot_print.Infrastucture.Output.ExceptionHandler.OwnException.BadFormatException;
import com.cruzroja.carbon_foot_print.Infrastucture.Output.ExceptionHandler.OwnException.BusinessRuleException;
import com.cruzroja.carbon_foot_print.Infrastucture.Output.ExceptionHandler.OwnException.EntityNotFoundException;
import com.cruzroja.carbon_foot_print.Infrastucture.Output.ExceptionHandler.OwnException.NoDataException;

/**
 * @interface ManageCompensationPlanCUIntPort
 * @brief Interfaz que define las operaciones de caso de uso para la gestión de
 *        planes de compensación.
 * 
 *        Esta interfaz proporciona los métodos necesarios para crear,
 *        actualizar, recuperar y gestionar planes de compensación en la
 *        aplicación.
 */
public interface ManageCompensationPlanCUIntPort {

    /**
     * @brief Recupera todos los planes dse compensación.
     * 
     *        Este método devuelve una lista de todos los planes de compensación
     *        registrados en el sistema.
     * 
     * @return Una lista de objetos de tipo CompensationPlan que representan todos
     *         los planes de compensación.
     * @throws NoDataException Si no se encuentran planes de compensación.
     */
    public List<CompensationPlan> finAllCompensationPlan();

    /**
     * @brief Guarda un nuevo plan de compensación.
     * 
     *        Este método permite registrar un nuevo plan de compensación en el
     *        sistema.
     * 
     * @param compensationPlan El objeto CompensationPlan que se desea guardar.
     * @return El objeto CompensationPlan que ha sido guardado con éxito.
     * @throws EntityExistsException Si el plan de compensación ya existe.
     * @throws BadFormatException    Si el formato del plan de compensación es
     *                               incorrecto.
     * @throws BusinessRuleException Si se viola alguna regla de negocio.
     */
    public CompensationPlan saveCompensationPlan(CompensationPlan compensationPlan, boolean isDefault,
            long volunteerId);

    /**
     * @brief Actualiza un plan de compensación existente.
     * 
     *        Este método permite actualizar los detalles de un plan de compensación
     *        ya existente.
     * 
     * @param compensationPlan El objeto CompensationPlan que contiene los datos
     *                         actualizados.
     * @return El objeto CompensationPlan que ha sido actualizado con éxito.
     * @throws EntityNotFoundException Si el plan de compensación no se encuentra.
     * @throws BadFormatException      Si el formato del plan de compensación es
     *                                 incorrecto.
     * @throws BusinessRuleException   Si se viola alguna regla de negocio.
     */
    public CompensationPlan updateCompensationPlan(CompensationPlan compensationPlan, long volunteerId);

    public CompensationPlan updateWithPrice(CompensationPlan compensationPlan, long volunteerId);

    /**
     * @brief Encuentra un plan de compensación por su identificador único.
     * 
     *        Este método busca un plan de compensación específico utilizando su
     *        identificador único.
     * 
     * @param planId El identificador único del plan de compensación que se desea
     *               encontrar.
     * @return El objeto CompensationPlan correspondiente al identificador
     *         proporcionado, o null si no se encuentra.
     * @throws EntityNotFoundException Si el plan de compensación no se encuentra.
     */
    public CompensationPlan findByCompensationPlanId(long planId);

    /**
     * @brief Encuentra un plan de compensación por su nombre.
     * 
     *        Este método busca un plan de compensación específico utilizando su
     *        nombre.
     * 
     * @param planName El nombre del plan de compensación que se desea encontrar.
     * @return El objeto CompensationPlan correspondiente al nombre proporcionado, o
     *         null si no se encuentra.
     * @throws EntityNotFoundException Si el plan de compensación no se encuentra.
     */
    public CompensationPlan findByCompesationPlanName(String planName);
}
