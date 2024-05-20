package com.cruzroja.carbon_foot_print.Infrastucture.Output.Persistence.Repositories;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.cruzroja.carbon_foot_print.Infrastucture.Output.Persistence.Entities.PollutionSourceEntity;
import com.cruzroja.carbon_foot_print.Infrastucture.Output.Persistence.Serealizables.PollutionSourceId;

public interface PollutionSourceRepository extends CrudRepository<PollutionSourceEntity, PollutionSourceId> {
    Optional<PollutionSourceEntity> findById(PollutionSourceId id);
    
}
