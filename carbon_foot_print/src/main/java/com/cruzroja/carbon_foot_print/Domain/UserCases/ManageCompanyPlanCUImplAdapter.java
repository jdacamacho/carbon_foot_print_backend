package com.cruzroja.carbon_foot_print.Domain.UserCases;

import java.util.List;

import com.cruzroja.carbon_foot_print.Application.Input.ManageCompanyPlanCUIntPort;
import com.cruzroja.carbon_foot_print.Application.Output.ExceptionFormatterIntPort;
import com.cruzroja.carbon_foot_print.Application.Output.ManageCompanyPlanGatewayIntPort;
import com.cruzroja.carbon_foot_print.Domain.Models.CompanyPlan;
import com.cruzroja.carbon_foot_print.Domain.Models.CompensationPlan;
import com.cruzroja.carbon_foot_print.Domain.Models.UserCompany;
import com.cruzroja.carbon_foot_print.Domain.Models.UserVolunteer;

public class ManageCompanyPlanCUImplAdapter implements ManageCompanyPlanCUIntPort {
    private final ManageCompanyPlanGatewayIntPort gateway;
    private final ExceptionFormatterIntPort exceptionFormatter;

    public ManageCompanyPlanCUImplAdapter(ManageCompanyPlanGatewayIntPort gateway,
            ExceptionFormatterIntPort exceptionFormatter) {
        this.gateway = gateway;
        this.exceptionFormatter = exceptionFormatter;
    }

    @Override
    public CompanyPlan save(long company, long seller, long plan) {
        CompensationPlan planDB = this.gateway.findPlanById(plan);
        if (planDB == null)
            this.exceptionFormatter.returnResponseBusinessRuleViolated("the plan entered is not in the system.");
        UserCompany companyDB = this.gateway.findCompanyById(company);
        if (companyDB == null)
            this.exceptionFormatter.returnResponseBusinessRuleViolated("the company entered is not in the system.");
        UserVolunteer volunteerDB = this.gateway.findVolunteerById(seller);
        if (volunteerDB == null)
            this.exceptionFormatter.returnResponseBusinessRuleViolated("the volunteer entered is not in the system.");
        return this.gateway.save(new CompanyPlan(companyDB, volunteerDB, planDB));
    }

    @Override
    public List<CompensationPlan> findCompaniesPlans(long nit) {
        List<CompensationPlan> planDB = this.gateway.findCompaniesPlans(nit);
        if (planDB == null)
            this.exceptionFormatter.returnResponseErrorEntityNotFound("the company has not plans.");
        return planDB;
    }

}
