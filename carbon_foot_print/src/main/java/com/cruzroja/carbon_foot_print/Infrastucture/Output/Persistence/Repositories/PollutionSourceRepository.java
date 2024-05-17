package com.cruzroja.carbon_foot_print.Infrastucture.Output.Persistence.Repositories;

import org.springframework.data.repository.CrudRepository;

import com.cruzroja.carbon_foot_print.Infrastucture.Output.Persistence.Entities.PollutionSourceEntity;
import com.cruzroja.carbon_foot_print.Infrastucture.Output.Persistence.Serealizables.PollutionSourceId;

public interface PollutionSourceRepository extends CrudRepository<PollutionSourceEntity, PollutionSourceId> {

}
