package com.cruzroja.carbon_foot_print.Infrastucture.Output.Persistence.Repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import com.cruzroja.carbon_foot_print.Infrastucture.Output.Persistence.Entities.PollutionTypeEntity;
import com.cruzroja.carbon_foot_print.Infrastucture.Output.Persistence.Entities.SourceEntity;

public interface PollutionTypeRepository extends CrudRepository<PollutionTypeEntity, Long> {

    boolean existsByPollutionTypeName(String name);

    List<PollutionTypeEntity> findByPollutionTypeName(String name);

    @Query("from SourceEntity")
    List<SourceEntity> findAllSources();

}