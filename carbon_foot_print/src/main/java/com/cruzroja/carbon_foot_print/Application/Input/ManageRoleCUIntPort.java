package com.cruzroja.carbon_foot_print.Application.Input;

import java.util.List;
import com.cruzroja.carbon_foot_print.Domain.Models.Role;

public interface ManageRoleCUIntPort {
    public List<Role> listRoles();
    public Role saveRole(Role role);
    public Role getRole(long idRole);
    public Role updateRole(Role role);
    public void deleteRole(long idRole);
}
