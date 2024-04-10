package com.cruzroja.carbon_foot_print.Infrastucture.Output.Persistence.Repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.cruzroja.carbon_foot_print.Infrastucture.Output.Persistence.Entities.PermissionEntity;
import com.cruzroja.carbon_foot_print.Infrastucture.Output.Persistence.Entities.RoleEntity;

public interface RoleRepository extends CrudRepository<RoleEntity,Long> {

    @Query("from PermissionEntity")
    List<PermissionEntity> findAllPermissions();

    @Query("SELECT COUNT(r) FROM RoleEntity r WHERE r.idRole = :idRole")
    long countByRoleId(@Param("idRole") long idRole);   

    @Query("SELECT COUNT(r) FROM RoleEntity r WHERE r.typeRole = :typeRole")
    long countByRoleName(@Param("typeRole") String typeRole);   
}
