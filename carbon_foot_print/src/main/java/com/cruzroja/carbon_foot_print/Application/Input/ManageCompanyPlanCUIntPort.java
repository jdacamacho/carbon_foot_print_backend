package com.cruzroja.carbon_foot_print.Application.Input;

import com.cruzroja.carbon_foot_print.Domain.Models.CompanyPlan;

public interface ManageCompanyPlanCUIntPort {
    CompanyPlan save(long company, long seller, long plan);
}
