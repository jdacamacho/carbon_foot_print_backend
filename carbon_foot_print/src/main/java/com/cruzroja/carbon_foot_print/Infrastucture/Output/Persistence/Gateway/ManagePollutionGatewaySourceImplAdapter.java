package com.cruzroja.carbon_foot_print.Infrastucture.Output.Persistence.Gateway;

import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeMap;
import org.modelmapper.TypeToken;
import org.springframework.stereotype.Service;

import com.cruzroja.carbon_foot_print.Application.Output.ManagePollutionSourceGatewayIntPort;
import com.cruzroja.carbon_foot_print.Domain.Models.PollutionSource;
import com.cruzroja.carbon_foot_print.Domain.Models.PollutionType;
import com.cruzroja.carbon_foot_print.Infrastucture.Output.Persistence.Entities.PollutionSourceEntity;
import com.cruzroja.carbon_foot_print.Infrastucture.Output.Persistence.Entities.PollutionTypeEntity;
import com.cruzroja.carbon_foot_print.Infrastucture.Output.Persistence.Repositories.PollutionSourceRepository;

@Service
public class ManagePollutionGatewaySourceImplAdapter implements ManagePollutionSourceGatewayIntPort{

    private final PollutionSourceRepository serviceBD;
    private final ModelMapper mapper;

    public ManagePollutionGatewaySourceImplAdapter(PollutionSourceRepository serviceBD,
                                            ModelMapper mapper){
        this.serviceBD = serviceBD;
        this.mapper = mapper;
    }

    @Override
    public PollutionSource findById(long idPollution, long idSource) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findById'");
    }

    @Override
    public List<PollutionSource> findAll() {
        Iterable<PollutionSourceEntity> dataFromBD = this.serviceBD.findAll();
        
        List<PollutionSource> response = this.mapper.map(dataFromBD, new TypeToken<List<PollutionSource>>(){}.getType());
        return response;
    }
    
}
