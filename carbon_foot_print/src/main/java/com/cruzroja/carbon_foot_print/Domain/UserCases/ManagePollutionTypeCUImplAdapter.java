package com.cruzroja.carbon_foot_print.Domain.UserCases;

import java.util.List;

import com.cruzroja.carbon_foot_print.Application.Input.ManagePollutionTypeCUIntPort;
import com.cruzroja.carbon_foot_print.Application.Output.ExceptionFormatterIntPort;
import com.cruzroja.carbon_foot_print.Application.Output.ManagePollutionTypeGatewayIntPort;
import com.cruzroja.carbon_foot_print.Domain.Models.PollutionType;

/**
 * Adaptador que implementa el puerto de entrada para gestionar los tipos de contaminación.
 */
public class ManagePollutionTypeCUImplAdapter implements ManagePollutionTypeCUIntPort {
    /** Puesta de enlace desde el dominio a los datos. */
    private final ManagePollutionTypeGatewayIntPort gateway;
    /** Utilidad para manejo de excepciones personalizadas. */
    private final ExceptionFormatterIntPort errorFormatter;

    /**
     * Constructor de la clase ManagePollutionTypeCUImplAdapter.
     *
     * @param gateway        Puesta de enlace desde el dominio a los datos.
     * @param errorFormatter Utilidad para manejo de excepciones personalizadas.
     */
    public ManagePollutionTypeCUImplAdapter(ManagePollutionTypeGatewayIntPort gateway,
                                            ExceptionFormatterIntPort errorFormatter) {
        this.gateway = gateway;
        this.errorFormatter = errorFormatter;
    }

    /**
     * Lista todos los tipos de contaminación disponibles.
     *
     * @return Lista de objetos PollutionType si se encuentran tipos de contaminación, o lanza una excepción si no se encuentra ninguno.
     */
    @Override
    public List<PollutionType> listPollutionTypes() {
        List<PollutionType> pollutionTypes = gateway.listPollutionTypes();
        if (pollutionTypes.isEmpty())
        errorFormatter.returNoData("No pollution types found in the system");
    return pollutionTypes;
}

/**
 * Guarda un nuevo tipo de contaminación si no existe otro con el mismo nombre y si las fuentes asociadas son válidas.
 *
 * @param pollutionType El tipo de contaminación a ser guardado.
 * @return El objeto PollutionType guardado, o lanza una excepción si no se cumplen las reglas de negocio.
 */
@Override
public PollutionType savePollutionType(PollutionType pollutionType) {
    if (gateway.existsByName(pollutionType.getPollutionTypeName()))
        errorFormatter.returnResponseErrorEntityExists("Pollution type with the same name already exists");
    if (!pollutionType.isValidSources(gateway.getSources()))
        errorFormatter.returnResponseErrorEntityNotFound("The sources entered are not found in the system");
    return gateway.savePollutionType(pollutionType);
}

/**
 * Actualiza un tipo de contaminación existente si cumple con las reglas de negocio.
 *
 * @param pollutionType El tipo de contaminación con la información actualizada.
 * @return El objeto PollutionType actualizado, o lanza una excepción si no se cumplen las reglas de negocio.
 */
@Override
public PollutionType updatePollutionType(PollutionType pollutionType) {
    if (!gateway.existsById(pollutionType.getPollutionTypeId()))
        errorFormatter.returnResponseErrorEntityNotFound("Pollution type not found");
    PollutionType old = this.gateway.getPollutionTypeById(pollutionType.getPollutionTypeId());
    if (!pollutionType.isValidSources(gateway.getSources()))
        errorFormatter.returnResponseErrorEntityNotFound("The sources entered are not found in the system");
    if (old.isNameUpdate(pollutionType.getPollutionTypeName()))
        if (gateway.existsByName(pollutionType.getPollutionTypeName()))
            errorFormatter.returnResponseErrorEntityExists("Pollution type with the same name already exists");
    if (!pollutionType.isValidUnits())
        errorFormatter.returnResponseBusinessRuleViolated(
                "The value of units must be in [\"Galón\", \"Kilogramo\", \"Metro Cúbico\"]");
    old.update(pollutionType);
    return gateway.updatePollutionType(old);
}

    /**
 * Encuentra todos los tipos de contaminación que coinciden con un nombre dado.
 *
 * @param name El nombre del tipo de contaminación a buscar.
 * @return Lista de objetos PollutionType encontrados, o una lista vacía si no se encuentra ninguno.
 */
@Override
public List<PollutionType> getPollutionTypeByName(String name) {
    return gateway.getPollutionTypeByName(name);
}

/**
 * Verifica si existe un tipo de contaminación con un nombre dado.
 *
 * @param name El nombre del tipo de contaminación a verificar.
 * @return `true` si existe un tipo de contaminación con el nombre dado, de lo contrario `false`.
 */
public boolean existsByName(String name) {
    return gateway.existsByName(name);
}

/**
 * Encuentra un tipo de contaminación por su identificador.
 *
 * @param pollutionTypeId El identificador del tipo de contaminación a buscar.
 * @return El objeto PollutionType encontrado, o `null` si no se encuentra ninguno.
 */
@Override
public PollutionType getPollutionTypeById(long pollutionTypeId) {
    return gateway.getPollutionTypeById(pollutionTypeId);
}

/**
 * Verifica si existe un tipo de contaminación con un identificador dado.
 *
 * @param id El identificador del tipo de contaminación a verificar.
 * @return `true` si existe un tipo de contaminación con el identificador dado, de lo contrario `false`.
 */
@Override
public boolean existsById(long id) {
    return gateway.existsById(id);
}

}
