package com.cruzroja.carbon_foot_print.Domain.Models;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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

    public User() {
        this.roles = new ArrayList<>();
    }

    public boolean isValidRoles(List<Role> validRoles) {
        List<Role> roles = this.getRoles();
        int wasFound = 0;
        for (Role role : roles) {
            for (Role roleValid : validRoles) {
                if (role.equals(roleValid))
                    wasFound++;
            }
        }
        if (roles.size() == wasFound)
            return true;
        return false;
    }

    public boolean hasDuplicateRoles(){
        Set<Role> roleSet = new HashSet<>(this.getRoles());
        if(roleSet.size() < this.getRoles().size()){
            return true;
        }
        return false;
    }

    protected void update(User user) {
        this.documentType = user.getDocumentType();
        this.names = user.getNames();
        this.lastNames = user.getLastNames();
        this.personalPhone = user.getPersonalPhone();
        this.personalEmail = user.getPersonalEmail();
        this.username = user.getUsername();
        this.roles = user.getRoles();
        this.state = user.isState();
    }
}
