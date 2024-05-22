package com.cruzroja.carbon_foot_print.Infrastucture.Output.Persistence.Repositories;

import org.springframework.data.repository.CrudRepository;

import com.cruzroja.carbon_foot_print.Infrastucture.Output.Persistence.Entities.ActionEntity;

public interface ActionRepository extends CrudRepository<ActionEntity, Long> {
    public ActionEntity  findByActionName(String actionName);
    public boolean existsByActionName(String actionName);
}
