package com.cruzroja.carbon_foot_print.Infrastucture.Input.ControllerManageCompanyPlan.DTOResponse;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UserDTOResponseBrief {
    private long documentNumber;
    private String documentType;
    private String names;
    private String lastNames;
    private String personalPhone;
    private String personalEmail;
    private String username;
    private boolean state;

    public UserDTOResponseBrief() {
    }
}
