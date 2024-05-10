package com.cruzroja.carbon_foot_print.Application.Output;

import com.cruzroja.carbon_foot_print.Domain.Models.PollutionType;
import com.cruzroja.carbon_foot_print.Domain.Models.Source;

import java.util.List;

public interface ManagePollutionTypeGatewayIntPort {

    public List<PollutionType> listPollutionTypes();

    public PollutionType savePollutionType(PollutionType pollutionType);

    public PollutionType updatePollutionType(PollutionType pollutionType);

    public PollutionType getPollutionTypeById(long pollutionTypeId);

    public List<PollutionType> getPollutionTypeByName(String name);

    public List<Source> getSources();

    public boolean existsByName(String name);

    public boolean existsById(long id);

}
