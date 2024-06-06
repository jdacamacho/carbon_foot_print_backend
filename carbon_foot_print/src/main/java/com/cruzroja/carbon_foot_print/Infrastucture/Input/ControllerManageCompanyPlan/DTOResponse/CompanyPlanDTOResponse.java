package com.cruzroja.carbon_foot_print.Infrastucture.Input.ControllerManageCompanyPlan.DTOResponse;

import java.util.Date;

import com.cruzroja.carbon_foot_print.Infrastucture.Input.ControllerManageCompensationPlan.DTOResponse.CompensationPlanDTOResponse;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CompanyPlanDTOResponse {
    CompanyDTOResponseBrief company;
    VolunteerDTOResponseBrief seller;
    CompensationPlanDTOResponse plan;
    Date sold;

    public CompanyPlanDTOResponse() {
    }

}
