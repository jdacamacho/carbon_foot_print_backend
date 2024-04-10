package com.cruzroja.carbon_foot_print.Domain.UserCases;

import java.util.List;

import org.modelmapper.ModelMapper;

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
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'saveRole'");
    }

    @Override
    public Role getRole(long idRole) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getRole'");
    }

    @Override
    public Role updateRole(Role role) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'updateRole'");
    }

    @Override
    public boolean deleteRole(long idRole) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deleteRole'");
    }
    
}
