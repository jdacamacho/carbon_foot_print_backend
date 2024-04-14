package com.cruzroja.carbon_foot_print.Infrastucture.Output.Persistence.Repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.cruzroja.carbon_foot_print.Infrastucture.Output.Persistence.Entities.RoleEntity;
import com.cruzroja.carbon_foot_print.Infrastucture.Output.Persistence.Entities.UserVolunteerEntity;
import java.util.List;

public interface UserVolunteerRepository extends CrudRepository<UserVolunteerEntity, Long> {
    List<UserVolunteerEntity> findByPosition(String position);

    @Query("from RoleEntity")
    List<RoleEntity> findAllRoles();
}
