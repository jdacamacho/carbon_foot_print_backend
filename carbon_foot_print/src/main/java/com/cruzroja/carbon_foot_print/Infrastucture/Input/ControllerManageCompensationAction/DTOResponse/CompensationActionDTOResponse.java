package com.cruzroja.carbon_foot_print.Infrastucture.Input.ControllerManageCompensationAction.DTOResponse;

import java.util.List;
import java.util.ArrayList;

import com.cruzroja.carbon_foot_print.Infrastucture.Input.ControllerManageCompensationPlan.DTOResponse.CompensationPlanDTOResponse;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CompensationActionDTOResponse {
    private CompensationPlanDTOResponse plan;
    private List<ActionWithAmountDTOResponse> actions;

    public CompensationActionDTOResponse() {
        this.actions = new ArrayList<>();
    }
}
