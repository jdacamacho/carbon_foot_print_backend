package com.cruzroja.carbon_foot_print.Infrastucture.Input.ControllerManageCompanyPlan.DTOResponse;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class VolunteerDTOResponseBrief extends UserDTOResponseBrief {
    private String position;

    public VolunteerDTOResponseBrief() {
    }
}
