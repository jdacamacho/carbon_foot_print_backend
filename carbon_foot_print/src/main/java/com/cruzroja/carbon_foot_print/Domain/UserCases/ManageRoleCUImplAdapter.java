package com.cruzroja.carbon_foot_print.Domain.UserCases;

import java.util.List;

import com.cruzroja.carbon_foot_print.Application.Input.ManageRoleCUIntPort;
import com.cruzroja.carbon_foot_print.Application.Output.ExceptionFormatterIntPort;
import com.cruzroja.carbon_foot_print.Application.Output.ManageRoleGatewayIntPort;
import com.cruzroja.carbon_foot_print.Domain.Models.Permission;
import com.cruzroja.carbon_foot_print.Domain.Models.Role;

public class ManageRoleCUImplAdapter implements ManageRoleCUIntPort {

    private final ManageRoleGatewayIntPort gateway;
    private final ExceptionFormatterIntPort exceptionFormatter;

    public ManageRoleCUImplAdapter(ManageRoleGatewayIntPort gateway,
            ExceptionFormatterIntPort exceptionFormatter) {
        this.gateway = gateway;
        this.exceptionFormatter = exceptionFormatter;
    }

    @Override
    public List<Role> listRoles() {
        List<Role> roles = this.gateway.findAll();
        if (roles.size() == 0) {
            this.exceptionFormatter.returNoData("Not exist roles in the system");
        }
        return roles;
    }

    @Override
    public Role saveRole(Role role) {
        Role roleResponse = null;
        if (this.gateway.existsByTypeRole(role.getTypeRole())) {
            this.exceptionFormatter.returnResponseErrorEntityExists("Role exists with that type Role in the system");
        } else {
            if (role.isValidPermission(this.gateway.findAllPermissions()) == false) {
                this.exceptionFormatter.returnResponseBusinessRuleViolated("Permissiones are not valid");
            } else if (role.hasDuplicatePermissions() == true) {
                this.exceptionFormatter.returnResponseBusinessRuleViolated("role has permissions duplicates");
            } else {
                roleResponse = this.gateway.save(role);
            }
        }
        return roleResponse;
    }

    @Override
    public Role getRole(long idRole) {
        Role roleResponse = null;
        if (!this.gateway.existsById(idRole)) {
            this.exceptionFormatter.returnResponseErrorEntityNotFound("Role not found");
        }
        roleResponse = this.gateway.findByIdRole(idRole);
        return roleResponse;
    }

    @Override
    public Role updateRole(Role role) {

        if (!this.gateway.existsById(role.getIdRole()))
            this.exceptionFormatter.returnResponseErrorEntityNotFound("Role not found");
        if (role.isValidPermission(this.gateway.findAllPermissions()) == false)
            this.exceptionFormatter.returnResponseBusinessRuleViolated("Permissiones are not valid");
        if (role.hasDuplicatePermissions() == true)
            this.exceptionFormatter.returnResponseBusinessRuleViolated("role has duplicates");
        Role roleObtained = this.gateway.findByIdRole(role.getIdRole());
        if (!roleObtained.verifyTypeRole(role.getTypeRole()))
            if (this.gateway.existsByTypeRole(role.getTypeRole()))
                this.exceptionFormatter.returnResponseErrorEntityExists("Exist a role with that typeRole");
        roleObtained.update(role.getTypeRole(), role.isState(), role.getPermissions());
        return this.gateway.save(roleObtained);
    }

    @Override
    public List<Permission> listPermissions() {
        List<Permission> permissions = this.gateway.findAllPermissions();
        if (permissions.size() == 0) {
            this.exceptionFormatter.returNoData("Not exists permissions in the system");
        }
        return permissions;
    }

}
