package com.cruzroja.carbon_foot_print.Infrastucture.Output.Persistence.Repositories;

import org.springframework.data.repository.CrudRepository;

import com.cruzroja.carbon_foot_print.Infrastucture.Output.Persistence.Entities.SourceEntity;

public interface SourceRepository extends CrudRepository<SourceEntity,Long> {
    boolean existsBySourceName(String sourceName);
    SourceEntity findBySourceName(String sourceName);
}
