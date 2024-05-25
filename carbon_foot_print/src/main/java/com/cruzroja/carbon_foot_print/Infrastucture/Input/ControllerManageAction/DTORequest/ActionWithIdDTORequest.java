package com.cruzroja.carbon_foot_print.Infrastucture.Input.ControllerManageAction.DTORequest;

import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ActionWithIdDTORequest {
    @Min(value = 1, message = "action's id must be major than one")
    private long actionId;
    
    @NotNull(message = "action's name can't be null")
    @NotBlank(message = "action's name can't be empty")
    @Size(min = 2, max = 45, message = "action's name must be between 2 and 45 characters")
    private String actionName;

    @NotNull(message = "action's description can't be null")
    @NotBlank(message = "action's description can't be empty")
    @Size(min = 10, max = 100, message = "action's description must be between 2 and 100 characters")
    private String actionDescription;

    @NotNull(message = "action's unitary price can't be null")
    @Min(value = 0, message = "action's unitary price can't be negative")
    @Digits(integer = 10, fraction = 2, message = "action's unitary price format is invalid")
    private double actionUnitaryPrice;

    public ActionWithIdDTORequest(){

    }
}
