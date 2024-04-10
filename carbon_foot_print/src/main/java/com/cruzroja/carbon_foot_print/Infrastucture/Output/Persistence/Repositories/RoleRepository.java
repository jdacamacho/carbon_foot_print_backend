package com.cruzroja.carbon_foot_print.Infrastucture.Output.Persistence.Repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.cruzroja.carbon_foot_print.Infrastucture.Output.Persistence.Entities.PermissionEntity;
import com.cruzroja.carbon_foot_print.Infrastucture.Output.Persistence.Entities.RoleEntity;

public interface RoleRepository extends CrudRepository<RoleEntity,Long> {
    @Query("SELECT COUNT(r) FROM RoleEntity r WHERE r.idRole = :idRole")
    long countByRoleId(@Param("idRole") long idRole);  

    @Query("SELECT COUNT(r) FROM RoleEntity r WHERE r.idRole = :idRole OR r.typeRole = :typeRole")
    long countByIdRoleOrTypeRole(@Param("idRole") long idRole,@Param("typeRole") String typeRole);

    @Query("from PermissionEntity")
    List<PermissionEntity> findAllPermissions();

}
