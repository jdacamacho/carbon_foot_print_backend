package com.cruzroja.carbon_foot_print.Application.Output;

import java.util.List;

import com.cruzroja.carbon_foot_print.Domain.Models.PollutionSource;
import com.cruzroja.carbon_foot_print.Infrastucture.Output.Persistence.Serealizables.PollutionSourceId;

public interface ManagePollutionSourceGatewayIntPort {
    public PollutionSource findById(long idPollution, long idSource);
    public List<PollutionSource> findAll();
    public List<PollutionSource> findAllByIds(List<PollutionSourceId> idPollutionSources);
}
