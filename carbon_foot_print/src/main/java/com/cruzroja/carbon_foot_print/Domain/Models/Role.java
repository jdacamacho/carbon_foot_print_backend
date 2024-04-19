package com.cruzroja.carbon_foot_print.Domain.Models;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Role {
    private long idRole;
    private String typeRole;
    private List<Permission> permissions;

    public Role(){
        this.permissions = new ArrayList<>();
    }

    public boolean isValidPermission(List<Permission> validPermissions){
        List<Permission> permissions = this.getPermissions();
        int wasFound = 0;
        for (Permission permission : permissions) {
            for (Permission validPermission : validPermissions) {
                if(permission.equals(validPermission)) wasFound ++;
            }
        }
        if(permissions.size() == wasFound) return true;
        return false;
    } 

    public boolean hasDuplicatePermissions(){
        Set<Permission> permissionSet = new HashSet<>(this.getPermissions());
        if(permissionSet.size() < this.getPermissions().size()){
            return true;
        }
        return false;
    }

}