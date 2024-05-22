package com.cruzroja.carbon_foot_print.Infrastucture.Input.ControllerManageAction.DTORequest;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ActionDTORequest {
    @NotNull(message = "action's name can't be null")
    @NotBlank(message = "action's name can't be empty")
    private String actionName;

    @NotNull(message = "action's description can't be null")
    @NotBlank(message = "action's description can't be empty")
    private String actionDescription;

    @Min(value = 0, message = "action's unitary price can't be negative")
    private double actionUnitaryPrice;

    public ActionDTORequest(){

    }
}
