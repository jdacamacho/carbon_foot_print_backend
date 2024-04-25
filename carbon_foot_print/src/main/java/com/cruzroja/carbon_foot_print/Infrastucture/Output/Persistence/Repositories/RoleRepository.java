package com.cruzroja.carbon_foot_print.Infrastucture.Output.Persistence.Repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.cruzroja.carbon_foot_print.Infrastucture.Output.Persistence.Entities.PermissionEntity;
import com.cruzroja.carbon_foot_print.Infrastucture.Output.Persistence.Entities.RoleEntity;

public interface RoleRepository extends CrudRepository<RoleEntity, Long> {

    boolean existsByTypeRole(String typeRole);

    @Query("from PermissionEntity")
    List<PermissionEntity> findAllPermissions();

}
