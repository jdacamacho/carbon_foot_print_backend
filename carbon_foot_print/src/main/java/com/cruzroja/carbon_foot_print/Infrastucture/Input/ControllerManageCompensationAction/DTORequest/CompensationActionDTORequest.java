package com.cruzroja.carbon_foot_print.Infrastucture.Input.ControllerManageCompensationAction.DTORequest;

import java.util.ArrayList;
import java.util.List;

import com.cruzroja.carbon_foot_print.Infrastucture.Input.ControllerManageCompensationPlan.DTORequest.CompensationPlanDTORequest;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CompensationActionDTORequest {
    @NotNull(message = "plan can't be null")
    @Valid
    private CompensationPlanDTORequest plan;

    @Size(min = 1, message = "Plan must have at least one action")
    @Valid
    private List<ActionWithAmountDTORequest> actions;

    public CompensationActionDTORequest() {
        this.actions = new ArrayList<>();
    }
}
