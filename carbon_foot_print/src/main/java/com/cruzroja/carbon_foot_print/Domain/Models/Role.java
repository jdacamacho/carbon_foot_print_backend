package com.cruzroja.carbon_foot_print.Domain.Models;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Role {
    private long id;
    private String typeRole;

    public Role(){
        
    }
}
