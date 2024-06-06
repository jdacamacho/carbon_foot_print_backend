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

    public ManagePollutionTypeCUImplAdapter(ManagePollutionTypeGatewayIntPort gateway,
                                            ExceptionFormatterIntPort errorFormatter) {
        this.gateway = gateway;
        this.errorFormatter = errorFormatter;
    }

    @Override
    public List<PollutionType> listPollutionTypes() {
        List<PollutionType> pollutionTypes = gateway.listPollutionTypes();
        if (pollutionTypes.isEmpty())
        errorFormatter.returNoData("No pollution types found in the system");
    return pollutionTypes;
}

    @Override
    public PollutionType savePollutionType(PollutionType pollutionType) {
        if (gateway.existsByName(pollutionType.getPollutionTypeName()))
            errorFormatter.returnResponseErrorEntityExists("Pollution type with the same name already exists");
        if (!pollutionType.isValidSources(gateway.getSources()))
            errorFormatter.returnResponseErrorEntityNotFound("The sources entered are not found in the system");
        return gateway.savePollutionType(pollutionType);
    }


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

    @Override
    public List<PollutionType> getPollutionTypeByName(String name) {
        return gateway.getPollutionTypeByName(name);
    }


    public boolean existsByName(String name) {
        return gateway.existsByName(name);
    }

    @Override
    public PollutionType getPollutionTypeById(long pollutionTypeId) {
        return gateway.getPollutionTypeById(pollutionTypeId);
    }

    @Override
    public boolean existsById(long id) {
        return gateway.existsById(id);
    }

}
