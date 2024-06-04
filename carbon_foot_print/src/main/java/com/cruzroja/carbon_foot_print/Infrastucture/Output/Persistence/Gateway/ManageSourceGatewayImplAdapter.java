package com.cruzroja.carbon_foot_print.Infrastucture.Output.Persistence.Gateway;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.stereotype.Service;

import com.cruzroja.carbon_foot_print.Application.Output.ManageSourceGatewayIntPort;
import com.cruzroja.carbon_foot_print.Domain.Models.Source;
import com.cruzroja.carbon_foot_print.Infrastucture.Output.Persistence.Entities.SourceEntity;
import com.cruzroja.carbon_foot_print.Infrastucture.Output.Persistence.Repositories.SourceRepository;

@Service
public class ManageSourceGatewayImplAdapter implements ManageSourceGatewayIntPort {
    private final SourceRepository serviceBD;
    private final ModelMapper mapper;

    public ManageSourceGatewayImplAdapter(SourceRepository serviceBD,
            ModelMapper mapper) {
        this.serviceBD = serviceBD;
        this.mapper = mapper;
    }

    @Override
    public List<Source> findAll() {
        Iterable<SourceEntity> dataFromBD = this.serviceBD.findAll();
        List<Source> response = this.mapper.map(dataFromBD, new TypeToken<List<Source>>() {
        }.getType());
        return response;
    }

    @Override
    public Source save(Source source) {
        SourceEntity sourceToSave = this.mapper.map(source, SourceEntity.class);
        SourceEntity sourceSaved = this.serviceBD.save(sourceToSave);
        Source response = this.mapper.map(sourceSaved, Source.class);
        return response;
    }

    @Override
    public Source findById(long idSource) {
        SourceEntity dataFromBD = this.serviceBD.findById(idSource).get();
        Source response = this.mapper.map(dataFromBD, Source.class);
        return response;
    }

    @Override
    public boolean existsById(long idCourse) {
        return this.serviceBD.existsById(idCourse);
    }

    @Override
    public Source findByName(String sourceName) {
        SourceEntity dataFromBD = this.serviceBD.findBySourceName(sourceName);
        Source response = this.mapper.map(dataFromBD, Source.class);
        return response;
    }

    @Override
    public boolean existsByName(String name) {
        return this.serviceBD.existsBySourceName(name);
    }

}
