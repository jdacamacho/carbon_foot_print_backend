package com.cruzroja.carbon_foot_print.Infrastucture.Output.Persistence.Repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.cruzroja.carbon_foot_print.Infrastucture.Output.Persistence.Entities.UserEntity;


public interface UserRepository  extends CrudRepository<UserEntity, Long>{
    
    @Query("SELECT COUNT(u) FROM UserEntity u WHERE u.documentNumber = :numberDocument OR u.username = :username OR u.personalEmail = :personalEmail")
    Long countByNumberDocumentOrUsernameOrPersonalEmail(@Param("numberDocument") long numberDocument,@Param("username") String username,@Param("personalEmail") String personalEmail);

    @Query("SELECT COUNT(u) FROM UserEntity u WHERE u.username = :username")
    Long countByUsername(@Param("username") String username);

    Optional<UserEntity> findByUsername(String username);

}
