package com.cruzroja.carbon_foot_print.Infrastucture.Input.ControllerManageCompanyPlan.DTOResponse;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CompanyDTOResponseBrief extends UserDTOResponseBrief {
    private long companyNit;
    private String companyName;
    private String companyPhone;
    private String companyEmail;
    private Date registrationDate;

    public CompanyDTOResponseBrief() {
    }

}
