package com.cruzroja.carbon_foot_print.Infrastucture.Output.Persistence.Gateway;

import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.cruzroja.carbon_foot_print.Application.Output.ManageCompanyPlanGatewayIntPort;
import com.cruzroja.carbon_foot_print.Domain.Models.CompanyPlan;
import com.cruzroja.carbon_foot_print.Domain.Models.CompensationPlan;
import com.cruzroja.carbon_foot_print.Domain.Models.UserCompany;
import com.cruzroja.carbon_foot_print.Domain.Models.UserVolunteer;
import com.cruzroja.carbon_foot_print.Infrastucture.Output.Persistence.Entities.CompanyPlanEntity;
import com.cruzroja.carbon_foot_print.Infrastucture.Output.Persistence.Entities.CompensationPlanEntity;
import com.cruzroja.carbon_foot_print.Infrastucture.Output.Persistence.Entities.UserCompanyEntity;
import com.cruzroja.carbon_foot_print.Infrastucture.Output.Persistence.Entities.UserVolunteerEntity;
import com.cruzroja.carbon_foot_print.Infrastucture.Output.Persistence.Repositories.CompanyPlanRepository;

@Service
public class ManageCompanyPlanGatewayImplAdapter implements ManageCompanyPlanGatewayIntPort {
    private final CompanyPlanRepository serviceDB;
    private final ModelMapper mapper;

    public ManageCompanyPlanGatewayImplAdapter(CompanyPlanRepository serviceDB, final ModelMapper mapper) {
        this.serviceDB = serviceDB;
        this.mapper = mapper;
    }

    @Override
    public CompanyPlan save(CompanyPlan request) {
        CompanyPlanEntity objToSave = this.mapper.map(request, CompanyPlanEntity.class);
        CompanyPlanEntity objToSaved = this.serviceDB.save(objToSave);
        return this.mapper.map(objToSaved, CompanyPlan.class);
    }

    @Override
    public UserVolunteer findVolunteerById(long volunteerId) {
        Optional<UserVolunteerEntity> dataDB = this.serviceDB.findVolunteerById(volunteerId);
        if (!dataDB.isPresent())
            return null;
        return this.mapper.map(dataDB.get(), UserVolunteer.class);
    }

    @Override
    public UserCompany findCompanyById(long companyId) {
        Optional<UserCompanyEntity> dataDB = this.serviceDB.findCompanyById(companyId);
        if (!dataDB.isPresent())
            return null;
        return this.mapper.map(dataDB.get(), UserCompany.class);
    }

    @Override
    public CompensationPlan findPlanById(long planId) {
        Optional<CompensationPlanEntity> dataDB = this.serviceDB.findPlanById(planId);
        if (!dataDB.isPresent())
            return null;
        return this.mapper.map(dataDB.get(), CompensationPlan.class);
    }

}
