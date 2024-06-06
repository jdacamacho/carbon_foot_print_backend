package com.cruzroja.carbon_foot_print.Infrastucture.Input.ControllerManageCompanyPlan.DTORequest;

import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CompanyPlanDTORequest {
    @Positive(message = "Company nit must be positive")
    private long companyNit;
    @Positive(message = "Seller id must be positive")
    private long sellerId;
    @Positive(message = "Plan id must be positive")
    private long planId;
}
