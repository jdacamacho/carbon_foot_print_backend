package com.cruzroja.carbon_foot_print.Domain.Models;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Action {
    private long actionId;
    private String actionName;
    private String actionDescription;
    private double actionUnitaryPrice;

    public Action(){

    }
}
