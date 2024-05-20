package com.cruzroja.carbon_foot_print.Infrastucture.Output.Persistence.Gateway;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.stereotype.Service;

import com.cruzroja.carbon_foot_print.Application.Output.ManagePollutionSourceGatewayIntPort;
import com.cruzroja.carbon_foot_print.Domain.Models.PollutionSource;
import com.cruzroja.carbon_foot_print.Infrastucture.Output.Persistence.Entities.PollutionSourceEntity;
import com.cruzroja.carbon_foot_print.Infrastucture.Output.Persistence.Repositories.PollutionSourceRepository;
import com.cruzroja.carbon_foot_print.Infrastucture.Output.Persistence.Serealizables.PollutionSourceId;

@Service
public class ManagePollutionSourceGatewayImplAdapter implements ManagePollutionSourceGatewayIntPort{

    private final PollutionSourceRepository serviceBD;
    private final ModelMapper mapper;

    public ManagePollutionSourceGatewayImplAdapter(PollutionSourceRepository serviceBD,
                                            ModelMapper mapper){
        this.serviceBD = serviceBD;
        this.mapper = mapper;
    }

    @Override
    public PollutionSource findById(long idPollution, long idSource) {
        Optional<PollutionSourceEntity> dataFromBD = this.serviceBD.findById(new PollutionSourceId(idPollution,idSource));
        if(dataFromBD.isPresent()){
            PollutionSource response = this.mapper.map(dataFromBD.get(), PollutionSource.class);
            return response;
        }
        return null;
    }

    @Override
    public List<PollutionSource> findAll() {
        Iterable<PollutionSourceEntity> dataFromBD = this.serviceBD.findAll();
        List<PollutionSource> response = this.mapper.map(dataFromBD, new TypeToken<List<PollutionSource>>(){}.getType());
        return response;
    }

    @Override
    public List<PollutionSource> findAllByIds(List<PollutionSourceId> idPollutionSources) {
        List<PollutionSource> data = new ArrayList<>();
        for(int i = 0 ; i < idPollutionSources.size() ; i++){
            PollutionSource p = this.findById(idPollutionSources.get(i).getPollution(),idPollutionSources.get(i).getSource() );
            if(p != null){
                data.add(p);
            }
        }
        List<PollutionSource> response = this.mapper.map(data, new TypeToken<List<PollutionSource>>(){}.getType());
        return response;
    }
    
}
