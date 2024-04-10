package com.cruzroja.carbon_foot_print.Domain.UserCases;

import java.util.List;

import com.cruzroja.carbon_foot_print.Application.Input.ManageRoleCUIntPort;
import com.cruzroja.carbon_foot_print.Application.Output.ExceptionFormatterIntPort;
import com.cruzroja.carbon_foot_print.Application.Output.ManageRoleGatewayIntPort;
import com.cruzroja.carbon_foot_print.Domain.Models.Role;

public class ManageRoleCUImplAdapter implements ManageRoleCUIntPort{
    private final ManageRoleGatewayIntPort gateway;
    private final ExceptionFormatterIntPort errorFormatter;

    public ManageRoleCUImplAdapter(ManageRoleGatewayIntPort gateway,
                                ExceptionFormatterIntPort errorFormatter){
        this.gateway = gateway;
        this.errorFormatter = errorFormatter;
    }

    @Override
    public List<Role> listRoles() {
        List<Role> roles = this.gateway.findAll();
        if(roles.size() == 0){
            this.errorFormatter.returNoData("Not exists roles in the system");
        }
        return roles;
    }

    @Override
    public Role saveRole(Role role) {
        Role response = null;

        if(this.gateway.existRoleById(role.getIdRole()) != 0 ){
            this.errorFormatter.returnResponseErrorEntityExists("Role duplicate");
        }
        else if(this.gateway.existsByTypeRole(role.getTypeRole()) != 0){
            this.errorFormatter.returnResponseErrorEntityExists("Role duplicate with that type role");
        }
        else if(role.isValidListPermissions(gateway.findAllPermissions()) == false){
            this.errorFormatter.returnResponseBadFormat("Permissions list ain't valid");
        }else if(role.hasDuplicatePermissions() == true){
            this.errorFormatter.returnResponseErrorEntityExists("Exist permissions duplicates");
        }else{
            response = this.gateway.save(role);
        }

        return response;
    }

    @Override
    public Role getRole(long idRole) {
        Role response = null;
        if(this.gateway.existRoleById(idRole) == 0){
            this.errorFormatter.returnResponseErrorEntityNotFound("Error, role not found");
        }
        response = this.gateway.findByIdRole(idRole);
        return response;
    }

    @Override
    public Role updateRole(Role role) {
        Role response = null;

        if(this.gateway.existRoleById(role.getIdRole()) == 0 ){
            this.errorFormatter.returnResponseErrorEntityNotFound("Role not found");
        }
        else if(this.gateway.existsByTypeRole(role.getTypeRole()) != 0){
            this.errorFormatter.returnResponseErrorEntityExists("Role duplicate with that type role");
        }
        else if(role.isValidListPermissions(gateway.findAllPermissions()) == false){
            this.errorFormatter.returnResponseBadFormat("Permissions list ain't valid");
        }else if(role.hasDuplicatePermissions() == true){
            this.errorFormatter.returnResponseErrorEntityExists("Exist permissions duplicates");
        }else{
            Role roleToUpdate = null;
            roleToUpdate = this.gateway.findByIdRole(role.getIdRole());
            roleToUpdate.setTypeRole(role.getTypeRole());
            roleToUpdate.setPermissions(role.getPermissions());
            response = this.gateway.save(roleToUpdate);
        }
        
        return response;
    }

    @Override
    public boolean deleteRole(long idRole) {
        Role objRole = null;
        if(this.gateway.existRoleById(idRole) == 0){
            this.errorFormatter.returnResponseErrorEntityNotFound("Error, role not found");
        }
        objRole = this.gateway.findByIdRole(idRole);
        this.gateway.deleteRole(objRole);
        return true;
    }


}
