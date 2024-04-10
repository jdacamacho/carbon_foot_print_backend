package com.cruzroja.carbon_foot_print.Domain.UserCases;

import java.util.List;

import com.cruzroja.carbon_foot_print.Application.Input.ManageRoleCUIntPort;
import com.cruzroja.carbon_foot_print.Application.Output.ExceptionFormatterIntPort;
import com.cruzroja.carbon_foot_print.Application.Output.ManageRoleGatewayIntPort;
import com.cruzroja.carbon_foot_print.Domain.Models.Role;

public class ManageRoleCUImplAdapter implements ManageRoleCUIntPort{

    private final ManageRoleGatewayIntPort gateway;
    private final ExceptionFormatterIntPort exceptionFormatter;

    public ManageRoleCUImplAdapter(ManageRoleGatewayIntPort gateway,
                                    ExceptionFormatterIntPort exceptionFormatter){
        this.gateway = gateway;
        this.exceptionFormatter = exceptionFormatter;
    }

    @Override
    public List<Role> listRoles() {
        List<Role> roles = this.gateway.findAll();
        if(roles.size() == 0){
            this.exceptionFormatter.returNoData("Not exist roles in the system");
        }
        return roles;
    }

    @Override
    public Role saveRole(Role role) {
        Role roleResponse = null;
        if(this.gateway.existRoleByIdOrTypeRole(role.getIdRole(), role.getTypeRole()) != 0){
            this.exceptionFormatter.returnResponseErrorEntityExists("Role exists in the system");
        }else if(role.isValidPermission(this.gateway.findAllPermissions()) == false){
            this.exceptionFormatter.returnResponseBusinessRuleViolated("Permissiones are not valid");
        }else if(role.hasDuplicatePermissions() == true){
            this.exceptionFormatter.returnResponseBusinessRuleViolated("role has duplicates");
        }else{
            roleResponse = this.gateway.save(role);
        }
        return roleResponse;
    }

    @Override
    public Role getRole(long idRole) {
        Role roleResponse = null;
        if(this.gateway.existRoleById(idRole) == 0){
            this.exceptionFormatter.returnResponseErrorEntityNotFound("Role not found");
        }
        roleResponse = this.gateway.findByIdRole(idRole);
        return roleResponse;
    }

    @Override
    public Role updateRole(Role role) {
        Role roleResponse = null;
        if(this.gateway.existRoleById(role.getIdRole()) == 0){
            this.exceptionFormatter.returnResponseErrorEntityNotFound("Role not exists in the system");
        }else{
            if(role.isValidPermission(this.gateway.findAllPermissions()) == false){
                this.exceptionFormatter.returnResponseBusinessRuleViolated("Permissiones are not valid");
            }else if(role.hasDuplicatePermissions() == true){
                this.exceptionFormatter.returnResponseBusinessRuleViolated("role has duplicates");
            }else{
                Role roleObtained = this.gateway.findByIdRole(role.getIdRole());
                if(IsValidUpdating(roleObtained, role) > 0){
                    this.exceptionFormatter.returnResponseErrorEntityExists("Exist a role with that typeRole");
                }else{
                    roleObtained.setTypeRole(role.getTypeRole());
                    roleObtained.setPermissions(role.getPermissions());
                    roleResponse = this.gateway.save(roleObtained);
                }
            }
        } 
        return roleResponse;
    }

    @Override
    public boolean deleteRole(long idRole) {
        Role roleToDelete = null;
        if(this.gateway.existRoleById(idRole) == 0){
            this.exceptionFormatter.returnResponseErrorEntityNotFound("Role not found");
        }
        roleToDelete = this.gateway.findByIdRole(idRole);
        this.gateway.deleteRole(roleToDelete);
        return true;
    }

    private long IsValidUpdating(Role roleObtained, Role newRole){

        long idRole = 0;
        String typeRole = "youWon'tFindThisTypeRole";

        if(roleObtained.getTypeRole().equals(newRole.getTypeRole())  == false) typeRole = newRole.getTypeRole();

        return this.gateway.existRoleByIdOrTypeRole(idRole, typeRole);
    } 
}
