package com.cruzroja.carbon_foot_print.Domain.UserCases;

import java.util.List;

import com.cruzroja.carbon_foot_print.Application.Input.ManagePollutionSourceIntPort;
import com.cruzroja.carbon_foot_print.Application.Output.ExceptionFormatterIntPort;
import com.cruzroja.carbon_foot_print.Application.Output.ManagePollutionSourceGatewayIntPort;
import com.cruzroja.carbon_foot_print.Domain.Models.PollutionSource;
import com.cruzroja.carbon_foot_print.Infrastucture.Output.Persistence.Serealizables.PollutionSourceId;

/**
 * Adaptador que implementa el puerto de entrada para gestionar fuentes de contaminación.
 */
public class ManagePollutionSourceCUImplAdapter implements ManagePollutionSourceIntPort {
    /** Puesta de enlace desde el dominio a los datos. */
    private final ManagePollutionSourceGatewayIntPort gateway;
    /** Utilidad para manejo de excepciones personalizadas. */
    private final ExceptionFormatterIntPort exceptionFormatter;

    public ManagePollutionSourceCUImplAdapter(ManagePollutionSourceGatewayIntPort gateway,
                                                ExceptionFormatterIntPort exceptionFormatter){
        this.gateway = gateway;
        this.exceptionFormatter = exceptionFormatter;
    }

    @Override
    public List<PollutionSource> listPollutionSources() {
        List<PollutionSource> objResponse = this.gateway.findAll();
        if(objResponse.size() == 0){
            this.exceptionFormatter.returNoData("No data was found");
        }
        return objResponse;
    }

    @Override
    public PollutionSource findById(long idPollution, long idSource) {
        PollutionSource response = this.gateway.findById(idPollution, idSource);
        if(response == null){
            this.exceptionFormatter.returnResponseErrorEntityNotFound("Entity not found");
        }
        return response;
    }

    @Override
    public List<PollutionSource> findAllById(List<PollutionSourceId> idPollutionsSources) {
        List<PollutionSource> objResponse = this.gateway.findAllByIds(idPollutionsSources);
        if(objResponse.size() == 0){
            this.exceptionFormatter.returNoData("No data was found");
        }
        return objResponse;
    }
    
}
