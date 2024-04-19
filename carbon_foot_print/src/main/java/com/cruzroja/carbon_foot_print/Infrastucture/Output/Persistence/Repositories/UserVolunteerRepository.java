package com.cruzroja.carbon_foot_print.Infrastucture.Output.Persistence.Repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.cruzroja.carbon_foot_print.Infrastucture.Output.Persistence.Entities.RoleEntity;
import com.cruzroja.carbon_foot_print.Infrastucture.Output.Persistence.Entities.UserVolunteerEntity;
import java.util.List;

public interface UserVolunteerRepository extends CrudRepository<UserVolunteerEntity, Long> {

    List<UserVolunteerEntity> findByPosition(String position);

    @Query("from RoleEntity")
    List<RoleEntity> findAllRoles();

    /**
     * Determina si existe o no un usuario registrado con el email ingresado.
     * (Spring Query Keywords)
     * 
     * @param personalEmail a String that represent the value of the email.
     * @return a boolean true if the user exist and false if don't exist.
     */
    boolean existsByPersonalEmail(String personalEmail);

    /**
     * Determina si existe o no un usuario registrado con el username ingresado
     * (utiliza Spring Query
     * Keywords).
     * 
     * @param username a String that represents the username value.
     * @return a bolean true if exist and false if don't exist.
     */
    boolean existsByUsername(String username);

    boolean existsByIdParent(long Id);
}
