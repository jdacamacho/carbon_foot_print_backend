package com.cruzroja.carbon_foot_print.Infrastucture.Output.Persistence.Repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.cruzroja.carbon_foot_print.Infrastucture.Output.Persistence.Entities.ActionEntity;
import com.cruzroja.carbon_foot_print.Infrastucture.Output.Persistence.Entities.CompensationPlanEntity;
import com.cruzroja.carbon_foot_print.Infrastucture.Output.Persistence.Entities.UserVolunteerEntity;

public interface CompensationPlanRepository extends CrudRepository<CompensationPlanEntity, Long> {
    public CompensationPlanEntity findByPlanName(String planName);

    public boolean existsByPlanName(String planName);

    @Query("SELECT v FROM UserVolunteerEntity v WHERE v.documentNumber = :volunteerId")
    public Optional<UserVolunteerEntity> findVolunteerById(long volunteerId);

    @Query("from ActionEntity")
    List<ActionEntity> findAllActions();
}
