package com.cruzroja.carbon_foot_print.Application.Input;

import com.cruzroja.carbon_foot_print.Domain.Models.PollutionType;

import java.util.List;

public interface ManagePollutionTypeCUIntPort {

    public List<PollutionType> listPollutionTypes();

    public PollutionType savePollutionType(PollutionType pollutionType);

    public PollutionType updatePollutionType(PollutionType pollutionType);

    public PollutionType getPollutionTypeById(long pollutionTypeId);

    public List<PollutionType> getPollutionTypeByName(String name);

    public boolean existsByName(String name);

    public boolean existsById(long id);
}
