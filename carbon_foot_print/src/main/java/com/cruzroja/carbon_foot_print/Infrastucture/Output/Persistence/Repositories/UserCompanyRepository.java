package com.cruzroja.carbon_foot_print.Infrastucture.Output.Persistence.Repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.cruzroja.carbon_foot_print.Infrastucture.Output.Persistence.Entities.UserCompanyEntity;

public interface UserCompanyRepository extends CrudRepository<UserCompanyEntity,Long>{
    @Query("SELECT COUNT(u) FROM UserCompanyEntity u WHERE u.companyNit = :companyNit")
    long countByCompanyNit(@Param("companyNit") long companyNit);

    @Query("SELECT COUNT(u) FROM UserCompanyEntity u WHERE u.documentNumber = :documentNumber")
    long countByUserCompanyNumberDocument(@Param("documentNumber") long documentNumber);

    UserCompanyEntity findByCompanyNit(long companyNit);
}
