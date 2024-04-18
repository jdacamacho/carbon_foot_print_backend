package com.cruzroja.carbon_foot_print.Infrastucture.Output.Persistence.Repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.cruzroja.carbon_foot_print.Infrastucture.Output.Persistence.Entities.RoleEntity;
import com.cruzroja.carbon_foot_print.Infrastucture.Output.Persistence.Entities.UserCompanyEntity;

public interface UserCompanyRepository extends CrudRepository<UserCompanyEntity,Long>{

    @Query("from RoleEntity")
    List<RoleEntity> findAllRoles();

    UserCompanyEntity findByCompanyNit(long companyNit);
   
    boolean existsByCompanyNit(long companyNit);
    
    boolean existsByCompanyNitOrCompanyEmailOrCompanyName(long nit, String companyEmail, String companyName);

}