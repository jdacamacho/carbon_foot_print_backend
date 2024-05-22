package com.cruzroja.carbon_foot_print.Infrastucture.Input.ControllerManageAction.DTOResponse;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ActionDTOResponse {
    private long actionId;
    private String actionName;
    private String actionDescription;
    private double actionUnitaryPrice;

    public ActionDTOResponse(){
        
    }
}
