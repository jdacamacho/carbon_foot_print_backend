package com.cruzroja.carbon_foot_print.Domain.Models;

import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class User {
    private long documentNumber;
    private String documentType;
    private String names;
    private String lastNames;
    private String personalPhone;
    private String personalEmail;
    private String username;
    private String password;
    private List<Role> roles;
    private boolean state;

    public User(){
        this.roles = new ArrayList<>();
    }

    public boolean isValidRole(List<Role> validRoles){
        List<Role> roles = this.getRoles();
        int wasFound = 0;
        for (Role role : roles) {
            for (Role roleValid : validRoles) {
                if(role.equals(roleValid)) wasFound ++;
            }
        }
        if(roles.size() == wasFound) return true;
        return false;
    }
}
