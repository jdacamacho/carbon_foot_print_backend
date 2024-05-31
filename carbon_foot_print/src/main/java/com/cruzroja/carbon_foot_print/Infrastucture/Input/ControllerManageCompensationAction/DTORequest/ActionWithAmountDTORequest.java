package com.cruzroja.carbon_foot_print.Infrastucture.Input.ControllerManageCompensationAction.DTORequest;

import com.cruzroja.carbon_foot_print.Infrastucture.Input.ControllerManageAction.DTORequest.ActionWithIdDTORequest;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ActionWithAmountDTORequest {
    @NotNull(message = "action can't be null.")
    @Valid
    private ActionWithIdDTORequest action;
    @Positive(message = "amount must be greater than 0.")
    private int amount;

    public ActionWithAmountDTORequest() {
    }
}
