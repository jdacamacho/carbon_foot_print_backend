package com.cruzroja.carbon_foot_print.Domain.Models;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Role {
    private long idRole;
    private String typeRole;
    private List<Permission> permissions;

    public Role(){
        
    }
}
