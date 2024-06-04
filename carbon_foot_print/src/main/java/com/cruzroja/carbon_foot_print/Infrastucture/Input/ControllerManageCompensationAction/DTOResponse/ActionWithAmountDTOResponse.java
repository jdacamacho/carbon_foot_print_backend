package com.cruzroja.carbon_foot_print.Infrastucture.Input.ControllerManageCompensationAction.DTOResponse;

import com.cruzroja.carbon_foot_print.Infrastucture.Input.ControllerManageAction.DTOResponse.ActionDTOResponse;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ActionWithAmountDTOResponse {
    private ActionDTOResponse action;
    private int amount;
    private double price;
    private double ufp;

    public ActionWithAmountDTOResponse() {
    }
}
