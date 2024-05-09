package com.cruzroja.carbon_foot_print.Domain.UserCases;

import java.util.List;

import com.cruzroja.carbon_foot_print.Application.Input.ManagePollutionTypeCUIntPort;
import com.cruzroja.carbon_foot_print.Application.Output.ExceptionFormatterIntPort;
import com.cruzroja.carbon_foot_print.Application.Output.ManagePollutionTypeGatewayIntPort;
import com.cruzroja.carbon_foot_print.Domain.Models.PollutionType;

public class ManagePollutionTypeCUImplAdapter implements ManagePollutionTypeCUIntPort {

    private final ManagePollutionTypeGatewayIntPort gateway;
    private final ExceptionFormatterIntPort errorFormatter;

    public ManagePollutionTypeCUImplAdapter(ManagePollutionTypeGatewayIntPort gateway,
                                            ExceptionFormatterIntPort errorFormatter) {
        this.gateway = gateway;
        this.errorFormatter = errorFormatter;
    }

    @Override
    public List<PollutionType> listPollutionTypes() {
        List<PollutionType> pollutionTypes = gateway.listPollutionTypes();
        if (pollutionTypes.isEmpty()) {
            errorFormatter.returNoData("No pollution types found in the system");
            throw new RuntimeException("No pollution types found in the system");
        }
        return pollutionTypes;
    }

    @Override
    public PollutionType savePollutionType(PollutionType pollutionType) {
        Long id = pollutionType.getId();
        if (id != null && gateway.existsById(pollutionType.getId())) {
            errorFormatter.returnResponseErrorEntityExists("Pollution type with the same ID already exists");
            // Lanzar una excepción adecuada en lugar de devolver null
            throw new RuntimeException("Pollution type with the same ID already exists");
        } else if (gateway.existsByName(pollutionType.getName())) {
            errorFormatter.returnResponseErrorEntityExists("Pollution type with the same name already exists");
            // Lanzar una excepción adecuada en lugar de devolver null
            throw new RuntimeException("Pollution type with the same name already exists");
        } else {
            return gateway.savePollutionType(pollutionType);
        }
    }

    @Override
    public PollutionType updatePollutionType(PollutionType pollutionType) {
        if (!gateway.existsById(pollutionType.getId())) {
            errorFormatter.returnResponseErrorEntityNotFound("Pollution type not found");
            // Lanzar una excepción adecuada en lugar de devolver null
            throw new RuntimeException("Pollution type not found");
        } else if (!isValidPollutionType(pollutionType)) {
            errorFormatter.returnResponseBusinessRuleViolated("Invalid pollution type data");
            // Lanzar una excepción adecuada en lugar de devolver null
            throw new RuntimeException("Invalid pollution type data");
        } else if (gateway.existsByName(pollutionType.getName())) {
            errorFormatter.returnResponseErrorEntityExists("Pollution type with the same name already exists");
            // Lanzar una excepción adecuada en lugar de devolver null
            throw new RuntimeException("Pollution type with the same name already exists");
        } else {
            return gateway.updatePollutionType(pollutionType);
        }
    }
    


    private boolean isValidPollutionType(PollutionType pollutionType) {
        if (pollutionType.getName() == null || pollutionType.getName().isEmpty()
            || pollutionType.getDescription() == null || pollutionType.getDescription().isEmpty()) {
            // Lanzar una excepción adecuada en lugar de devolver false
            throw new IllegalArgumentException("Name and description must not be null or empty");
        }
        if (pollutionType.getEmissionFactor() <= 0) {
            // Lanzar una excepción adecuada en lugar de devolver false
            throw new IllegalArgumentException("Emission factor must be greater than 0");
        }
        if (pollutionType.getUnits() == null || pollutionType.getUnits().isEmpty()) {
            // Lanzar una excepción adecuada en lugar de devolver false
            throw new IllegalArgumentException("Units must not be null or empty");
        }
        return true;
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
