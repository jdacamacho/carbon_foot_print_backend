package com.cruzroja.carbon_foot_print.Application.Output;

import com.cruzroja.carbon_foot_print.Domain.Models.PollutionType;
import com.cruzroja.carbon_foot_print.Domain.Models.Source;

import java.util.List;

/**
 * Interfaz para la gestión de tipos de contaminación.
 */
public interface ManagePollutionTypeGatewayIntPort {

    /**
     * Obtiene una lista de todos los tipos de contaminación.
     * 
     * Este método recupera todos los tipos de contaminación disponibles en el sistema.
     * 
     * @return Una lista de todos los tipos de contaminación disponibles.
     */
    public List<PollutionType> listPollutionTypes();

    /**
     * Guarda un nuevo tipo de contaminación.
     * 
     * Este método permite almacenar un nuevo tipo de contaminación en el sistema.
     * 
     * @param pollutionType El tipo de contaminación a guardar. No debe ser null.
     * @return El tipo de contaminación guardado, incluyendo cualquier información generada por el sistema (como un ID).
     */
    public PollutionType savePollutionType(PollutionType pollutionType);

    /**
     * Actualiza un tipo de contaminación existente.
     * 
     * Este método permite actualizar la información de un tipo de contaminación ya existente.
     * 
     * @param pollutionType El tipo de contaminación a actualizar, que debe contener un ID válido y no debe ser null.
     * @return El tipo de contaminación actualizado, o null si no se encuentra el tipo de contaminación.
     */
    public PollutionType updatePollutionType(PollutionType pollutionType);

    /**
     * Obtiene un tipo de contaminación por su identificador único.
     * 
     * Este método busca un tipo de contaminación específico usando su ID único.
     * 
     * @param pollutionTypeId El identificador único del tipo de contaminación a buscar.
     * @return El tipo de contaminación encontrado, o null si no se encuentra un tipo de contaminación con el ID proporcionado.
     */
    public PollutionType getPollutionTypeById(long pollutionTypeId);

    /**
     * Obtiene una lista de tipos de contaminación por su nombre.
     * 
     * Este método busca tipos de contaminación específicos usando su nombre.
     * 
     * @param name El nombre del tipo de contaminación a buscar. No debe ser null.
     * @return Una lista de tipos de contaminación encontrados, o una lista vacía si no se encuentran tipos de contaminación con el nombre proporcionado.
     */
    public List<PollutionType> getPollutionTypeByName(String name);

    /**
     * Obtiene una lista de todas las fuentes.
     * 
     * Este método recupera todas las fuentes disponibles en el sistema.
     * 
     * @return Una lista de todas las fuentes disponibles.
     */
    public List<Source> getSources();

    /**
     * Verifica si un tipo de contaminación existe por su nombre.
     * 
     * Este método comprueba si un tipo de contaminación con el nombre proporcionado existe en el sistema.
     * 
     * @param name El nombre del tipo de contaminación a verificar. No debe ser null.
     * @return true si el tipo de contaminación existe, false en caso contrario.
     */
    public boolean existsByName(String name);

    /**
     * Verifica si un tipo de contaminación existe por su identificador único.
     * 
     * Este método comprueba si un tipo de contaminación con el ID proporcionado existe en el sistema.
     * 
     * @param id El identificador único del tipo de contaminación a verificar.
     * @return true si el tipo de contaminación existe, false en caso contrario.
     */
    public boolean existsById(long id);
}
