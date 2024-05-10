package com.cruzroja.carbon_foot_print.Infrastucture.Output.Persistence.Gateway;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.stereotype.Service;

import com.cruzroja.carbon_foot_print.Application.Output.ManagePollutionTypeGatewayIntPort;
import com.cruzroja.carbon_foot_print.Domain.Models.PollutionType;
import com.cruzroja.carbon_foot_print.Domain.Models.Source;
import com.cruzroja.carbon_foot_print.Infrastucture.Output.Persistence.Entities.PollutionTypeEntity;
import com.cruzroja.carbon_foot_print.Infrastucture.Output.Persistence.Entities.SourceEntity;
import com.cruzroja.carbon_foot_print.Infrastucture.Output.Persistence.Repositories.PollutionTypeRepository;

@Service
public class ManagePollutionTypeGatewayImplAdapter implements ManagePollutionTypeGatewayIntPort {

    private final PollutionTypeRepository serviceDB;
    private final ModelMapper mapper;

    public ManagePollutionTypeGatewayImplAdapter(PollutionTypeRepository serviceDB, ModelMapper mapper) {
        this.serviceDB = serviceDB;
        this.mapper = mapper;
    }

    @Override
    public List<PollutionType> listPollutionTypes() {
        List<PollutionTypeEntity> pollutionTypeEntities = (List<PollutionTypeEntity>) serviceDB.findAll();
        return pollutionTypeEntities.stream().map(entity -> mapper.map(entity, PollutionType.class))
                .collect(Collectors.toList());
    }

    @Override
    public PollutionType savePollutionType(PollutionType pollutionType) {
        PollutionTypeEntity pollutionTypeEntity = mapper.map(pollutionType, PollutionTypeEntity.class);
        PollutionTypeEntity savedEntity = serviceDB.save(pollutionTypeEntity);
        return mapper.map(savedEntity, PollutionType.class);
    }

    @Override
    public PollutionType updatePollutionType(PollutionType pollutionType) {
        PollutionTypeEntity pollutionTypeEntity = mapper.map(pollutionType, PollutionTypeEntity.class);
        PollutionTypeEntity updatedEntity = serviceDB.save(pollutionTypeEntity);
        return mapper.map(updatedEntity, PollutionType.class);
    }

    @Override
    public PollutionType getPollutionTypeById(long pollutionTypeId) {
        PollutionTypeEntity pollutionTypeEntity = serviceDB.findById(pollutionTypeId)
                .orElseThrow(
                        () -> new IllegalArgumentException("Pollution type not found with id: " + pollutionTypeId));
        return mapper.map(pollutionTypeEntity, PollutionType.class);
    }

    @Override
    public List<PollutionType> getPollutionTypeByName(String name) {
        List<PollutionTypeEntity> pollutionTypeEntities = serviceDB.findByName(name);
        return pollutionTypeEntities.stream().map(entity -> mapper.map(entity, PollutionType.class))
                .collect(Collectors.toList());
    }

    @Override
    public boolean existsByName(String name) {
        return serviceDB.existsByName(name);
    }

    @Override
    public boolean existsById(long id) {
        return serviceDB.existsById(id);
    }

    @Override
    public List<Source> getSources() {
        List<SourceEntity> entities = serviceDB.findAllSources();
        return mapper.map(entities, new TypeToken<List<Source>>() {
        }.getType());
    }

}
