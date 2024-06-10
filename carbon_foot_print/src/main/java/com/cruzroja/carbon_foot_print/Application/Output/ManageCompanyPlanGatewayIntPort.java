package com.cruzroja.carbon_foot_print.Application.Output;

import java.util.List;

import com.cruzroja.carbon_foot_print.Domain.Models.CompanyPlan;
import com.cruzroja.carbon_foot_print.Domain.Models.CompensationPlan;
import com.cruzroja.carbon_foot_print.Domain.Models.UserCompany;
import com.cruzroja.carbon_foot_print.Domain.Models.UserVolunteer;

public interface ManageCompanyPlanGatewayIntPort {
    public CompanyPlan save(CompanyPlan request);

    public UserVolunteer findVolunteerById(long volunteerId);

    public UserCompany findCompanyById(long companyId);

    public CompensationPlan findPlanById(long planId);

    public List<CompensationPlan> findCompaniesPlans(long nit);
}
