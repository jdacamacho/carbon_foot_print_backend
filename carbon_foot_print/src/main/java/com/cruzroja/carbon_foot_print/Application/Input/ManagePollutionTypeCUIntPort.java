package com.cruzroja.carbon_foot_print.Application.Input;

import com.cruzroja.carbon_foot_print.Domain.Models.PollutionType;

import java.util.List;

/**
 * Interfaz para la gestión de tipos de contaminación.
 */
public interface ManagePollutionTypeCUIntPort {

    /**
     * Obtiene una lista de todos los tipos de contaminación.
     * 
     * @return Una lista de todos los tipos de contaminación.
     */
    List<PollutionType> listPollutionTypes();

    /**
     * Guarda un nuevo tipo de contaminación.
     * Reglas de negocio:
     * 1. El nombre del tipo de contaminación no debe estar registrado previamente en la base de datos.
     *    Código de error: 406
     * 
     * @param pollutionType El tipo de contaminación a guardar.
     * @return El tipo de contaminación guardado.
     */
    PollutionType savePollutionType(PollutionType pollutionType);

    /**
     * Actualiza un tipo de contaminación existente.
     * Reglas de negocio:
     * 1. El tipo de contaminación debe existir en la base de datos.
     *    Código de error: 404
     * 2. El nombre actualizado no debe estar registrado previamente en la base de datos.
     *    Código de error: 406
     * 
     * @param pollutionType El tipo de contaminación a actualizar.
     * @return El tipo de contaminación actualizado.
     */
    PollutionType updatePollutionType(PollutionType pollutionType);

    /**
     * Obtiene un tipo de contaminación por su identificador único.
     * Reglas de negocio:
     * 1. El tipo de contaminación debe existir en la base de datos.
     *    Código de error: 404
     * 
     * @param pollutionTypeId El identificador único del tipo de contaminación.
     * @return El tipo de contaminación encontrado, o null si no se encuentra.
     */
    PollutionType getPollutionTypeById(long pollutionTypeId);

    /**
     * Obtiene una lista de tipos de contaminación por su nombre.
     * 
     * @param name El nombre del tipo de contaminación a buscar.
     * @return Una lista de tipos de contaminación que coinciden con el nombre especificado.
     */
    List<PollutionType> getPollutionTypeByName(String name);

    /**
     * Verifica si existe un tipo de contaminación con el nombre especificado.
     * Reglas de negocio:
     * 1. El nombre del tipo de contaminación debe estar registrado en la base de datos.
     *    Código de error: 404
     * 
     * @param name El nombre del tipo de contaminación a verificar.
     * @return true si existe un tipo de contaminación con el nombre especificado, false en caso contrario.
     */
    boolean existsByName(String name);

    /**
     * Verifica si existe un tipo de contaminación con el identificador especificado.
     * Reglas de negocio:
     * 1. El identificador del tipo de contaminación debe estar registrado en la base de datos.
     *    Código de error: 404
     * 
     * @param id El identificador del tipo de contaminación a verificar.
     * @return true si existe un tipo de contaminación con el identificador especificado, false en caso contrario.
     */
    boolean existsById(long id);
}

