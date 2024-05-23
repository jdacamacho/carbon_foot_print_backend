package com.cruzroja.carbon_foot_print.Infrastucture.Output.Persistence.Repositories;

import org.springframework.data.repository.CrudRepository;

import com.cruzroja.carbon_foot_print.Infrastucture.Output.Persistence.Entities.CompensationPlanEntity;

public interface CompensationPlanRepository extends CrudRepository<CompensationPlanEntity,Long> {
    public CompensationPlanEntity findByPlanName(String planName);
    public boolean existsByPlanName(String planName);
}
