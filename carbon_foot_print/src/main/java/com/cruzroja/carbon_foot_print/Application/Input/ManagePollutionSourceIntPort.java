package com.cruzroja.carbon_foot_print.Application.Input;

import java.util.List;

import com.cruzroja.carbon_foot_print.Domain.Models.PollutionSource;
import com.cruzroja.carbon_foot_print.Infrastucture.Output.Persistence.Serealizables.PollutionSourceId;

public interface ManagePollutionSourceIntPort {
    public List<PollutionSource> listPollutionSources();
    public PollutionSource findById(long idPollution, long idSource);
    public List<PollutionSource> findAllById(List<PollutionSourceId> idPollutionsSources);
}
