package com.cruzroja.carbon_foot_print.Infrastucture.Output.Persistence.Repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.cruzroja.carbon_foot_print.Infrastucture.Output.Persistence.Entities.ActionEntity;
import com.cruzroja.carbon_foot_print.Infrastucture.Output.Persistence.Entities.CompensationActionEntity;
import com.cruzroja.carbon_foot_print.Infrastucture.Output.Persistence.Serealizables.CompensationActionId;

public interface CompensationActionRepository extends CrudRepository<CompensationActionEntity, CompensationActionId> {
    public List<CompensationActionEntity> findByPlanPlanId(long planId);

    public List<CompensationActionEntity> findByPlanPlanName(String planName);

    @Query("from ActionEntity")
    List<ActionEntity> findAllActions();

}
