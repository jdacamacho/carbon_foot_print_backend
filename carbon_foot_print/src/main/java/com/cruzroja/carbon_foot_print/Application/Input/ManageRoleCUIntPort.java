package com.cruzroja.carbon_foot_print.Application.Input;

import java.util.List;

import com.cruzroja.carbon_foot_print.Domain.Models.Permission;
import com.cruzroja.carbon_foot_print.Domain.Models.Role;

public interface ManageRoleCUIntPort {
    public List<Role> listRoles();
    public Role saveRole(Role role);
    public Role getRole(long idRole);
    public Role updateRole(long idRole, Role role);
    public boolean deleteRole(long idRole);
    public List<Permission> listPermissions();
}
