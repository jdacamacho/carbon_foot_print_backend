package com.cruzroja.carbon_foot_print.Infrastucture.Input.ControllerManageCompensationPlan.DTORequest;

import java.util.ArrayList;
import java.util.List;

import com.cruzroja.carbon_foot_print.Infrastucture.Input.ControllerManageAction.DTORequest.ActionWithIdDTORequest;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CompensationPlanWithIdDTORequest {
    @Min(value = 1, message = "action's id must be major than one")
    private long planId;

    @NotNull(message = "plan's name can't be null")
    @NotBlank(message = "plan's name can't be empty")
    private String planName;

    @Min(value = 0, message = "plan's price can't be negative")
    private double planPrice;

    @NotNull(message = "plan's description can't be null")
    @NotBlank(message = "plan's description can't be empty")
    private String planDescription;

    @Min(value = 0, message = "action's discount can't be negative")
    private int planDiscount;

    @Size(min = 1, message = "Plan's must have at least one action")
    @Valid
    private List<ActionWithIdDTORequest> actions;

    public CompensationPlanWithIdDTORequest(){
        this.actions = new ArrayList<>();
    }
}
