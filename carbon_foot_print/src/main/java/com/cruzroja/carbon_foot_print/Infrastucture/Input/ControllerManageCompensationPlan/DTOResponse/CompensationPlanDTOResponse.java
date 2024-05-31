package com.cruzroja.carbon_foot_print.Infrastucture.Input.ControllerManageCompensationPlan.DTOResponse;

import java.util.ArrayList;
import java.util.List;

import com.cruzroja.carbon_foot_print.Infrastucture.Input.ControllerManageAction.DTOResponse.ActionDTOResponse;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CompensationPlanDTOResponse {
    private long planId;
    private String planName;
    private double planPrice;
    private String planDescription;
    private double planDiscount;

    public CompensationPlanDTOResponse() {
    }
}
