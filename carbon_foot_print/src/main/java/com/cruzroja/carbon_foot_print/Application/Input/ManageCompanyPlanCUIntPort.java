package com.cruzroja.carbon_foot_print.Application.Input;

import java.util.List;

import com.cruzroja.carbon_foot_print.Domain.Models.CompanyPlan;
import com.cruzroja.carbon_foot_print.Domain.Models.CompensationPlan;

public interface ManageCompanyPlanCUIntPort {
    CompanyPlan save(long company, long seller, long plan);

    List<CompensationPlan> findCompaniesPlans(long nit);
}
