package com.cruzroja.carbon_foot_print.Infrastucture.Output.Persistence.Repositories;

import java.util.Optional;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.cruzroja.carbon_foot_print.Infrastucture.Output.Persistence.Entities.CompanyPlanEntity;
import com.cruzroja.carbon_foot_print.Infrastucture.Output.Persistence.Entities.CompensationPlanEntity;
import com.cruzroja.carbon_foot_print.Infrastucture.Output.Persistence.Entities.UserCompanyEntity;
import com.cruzroja.carbon_foot_print.Infrastucture.Output.Persistence.Entities.UserVolunteerEntity;
import com.cruzroja.carbon_foot_print.Infrastucture.Output.Persistence.Serealizables.CompanyPlanId;

public interface CompanyPlanRepository extends CrudRepository<CompanyPlanEntity, CompanyPlanId> {
    public List<CompanyPlanEntity> findByCompanyCompanyNit(long nit);

    @Query("SELECT v FROM UserVolunteerEntity v WHERE v.documentNumber = :volunteerId")
    public Optional<UserVolunteerEntity> findVolunteerById(long volunteerId);

    @Query("SELECT v FROM UserCompanyEntity v WHERE v.companyNit = :nit")
    public Optional<UserCompanyEntity> findCompanyById(long nit);

    @Query("SELECT v FROM CompensationPlanEntity v WHERE v.planId = :planId")
    public Optional<CompensationPlanEntity> findPlanById(long planId);
}
