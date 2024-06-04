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

    /**
     * Constructor de la clase ManagePollutionSourceCUImplAdapter.
     *
     * @param gateway             Puesta de enlace desde el dominio a los datos.
     * @param exceptionFormatter Utilidad para manejo de excepciones personalizadas.
     */
    public ManagePollutionSourceCUImplAdapter(ManagePollutionSourceGatewayIntPort gateway,
                                                ExceptionFormatterIntPort exceptionFormatter){
        this.gateway = gateway;
        this.exceptionFormatter = exceptionFormatter;
    }

    /**
     * Lista todas las fuentes de contaminación disponibles.
     *
     * @return Lista de objetos PollutionSource si se encuentran fuentes, o lanza una excepción si no se encuentra ninguna.
     */
    @Override
    public List<PollutionSource> listPollutionSources() {
        List<PollutionSource> objResponse = this.gateway.findAll();
        if(objResponse.size() == 0){
            this.exceptionFormatter.returNoData("No data was found");
        }
        return objResponse;
    }

    /**
     * Encuentra una fuente de contaminación por su identificador.
     *
     * @param idPollution El identificador de la contaminación asociada.
     * @param idSource    El identificador de la fuente de contaminación a buscar.
     * @return El objeto PollutionSource encontrado, o lanza una excepción si no se encuentra ninguna.
     */
    @Override
    public PollutionSource findById(long idPollution, long idSource) {
        PollutionSource response = this.gateway.findById(idPollution, idSource);
        if(response == null){
            this.exceptionFormatter.returnResponseErrorEntityNotFound("Entity not found");
        }
        return response;
    }

    /**
     * Encuentra todas las fuentes de contaminación por una lista de identificadores.
     *
     * @param idPollutionsSources Lista de identificadores de fuentes de contaminación.
     * @return Lista de objetos PollutionSource encontrados, o lanza una excepción si no se encuentra ninguna.
     */
    @Override
    public List<PollutionSource> findAllById(List<PollutionSourceId> idPollutionsSources) {
        List<PollutionSource> objResponse = this.gateway.findAllByIds(idPollutionsSources);
        if(objResponse.size() == 0){
            this.exceptionFormatter.returNoData("No data was found");
        }
        return objResponse;
    }
    
}
