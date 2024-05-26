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
    @Size(min = 2, max = 45, message = "plan's name must be between 2 and 45 characters")
    private String planName;

    @NotNull(message = "plan's description can't be null")
    @NotBlank(message = "plan's description can't be empty")
    @Size(min = 10, max = 100, message = "plan's description must be between 10 and 100 characters")
    private String planDescription;

    @Min(value = 0, message = "action's discount can't be negative")
    private double planDiscount;

    @Size(min = 1, message = "Plan's must have at least one action")
    @Valid
    private List<ActionWithIdDTORequest> actions;

    public CompensationPlanWithIdDTORequest(){
        this.actions = new ArrayList<>();
    }
}
