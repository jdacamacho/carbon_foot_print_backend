package com.cruzroja.carbon_foot_print.Infrastucture.Output.Persistence.Repositories;

import org.springframework.data.repository.CrudRepository;

import com.cruzroja.carbon_foot_print.Infrastucture.Output.Persistence.Entities.UserCompanyEntity;

public interface UserCompanyRepository extends CrudRepository<UserCompanyEntity,Long>{
    boolean existsByCompanyNit(long companyNit);
    UserCompanyEntity findByCompanyNitOrCompanyEmailOrCompanyName(long nit, String companyEmail, String companyName);
}
