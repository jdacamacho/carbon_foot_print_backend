package com.cruzroja.carbon_foot_print.Application.Output;

import java.util.List;

import com.cruzroja.carbon_foot_print.Domain.Models.PollutionSource;

public interface ManagePollutionSourceGatewayIntPort {
    public PollutionSource findById(long idPollution, long idSource);
    public List<PollutionSource> findAll();
}
