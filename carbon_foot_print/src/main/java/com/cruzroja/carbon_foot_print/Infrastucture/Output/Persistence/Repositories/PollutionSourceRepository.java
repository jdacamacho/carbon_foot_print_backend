package com.cruzroja.carbon_foot_print.Infrastucture.Output.Persistence.Repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.cruzroja.carbon_foot_print.Infrastucture.Output.Persistence.Entities.PollutionSourceEntity;
import com.cruzroja.carbon_foot_print.Infrastucture.Output.Persistence.Serealizables.PollutionSourceId;

public interface PollutionSourceRepository extends CrudRepository<PollutionSourceEntity, PollutionSourceId> {
    Optional<PollutionSourceEntity> findById(PollutionSourceId id);
    
    @Query("SELECT p FROM PollutionSourceEntity p WHERE (p.pollution.id, p.source.id) IN :ids")
    List<PollutionSourceEntity> findByIdIn(@Param("ids") List<PollutionSourceId> ids);
}
