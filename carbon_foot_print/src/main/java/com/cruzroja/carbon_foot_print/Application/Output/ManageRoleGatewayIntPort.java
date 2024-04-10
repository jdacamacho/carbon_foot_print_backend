package com.cruzroja.carbon_foot_print.Application.Output;

import java.util.List;

import com.cruzroja.carbon_foot_print.Domain.Models.Role;

public interface ManageRoleGatewayIntPort {
    public List<Role> findAll();
    public Role save(Role role);
    public Role findByIdRole(long idRole);
    public long existRoleById(long idRole);
    public void deleteRole(Role role);
}