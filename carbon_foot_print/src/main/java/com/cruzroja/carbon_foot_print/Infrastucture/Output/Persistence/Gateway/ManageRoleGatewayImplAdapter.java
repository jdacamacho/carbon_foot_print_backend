package com.cruzroja.carbon_foot_print.Infrastucture.Output.Persistence.Gateway;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.stereotype.Service;

import com.cruzroja.carbon_foot_print.Application.Output.ManageRoleGatewayIntPort;
import com.cruzroja.carbon_foot_print.Domain.Models.Permission;
import com.cruzroja.carbon_foot_print.Domain.Models.Role;
import com.cruzroja.carbon_foot_print.Infrastucture.Output.Persistence.Entities.PermissionEntity;
import com.cruzroja.carbon_foot_print.Infrastucture.Output.Persistence.Entities.RoleEntity;
import com.cruzroja.carbon_foot_print.Infrastucture.Output.Persistence.Repositories.RoleRepository;

@Service
public class ManageRoleGatewayImplAdapter implements ManageRoleGatewayIntPort{

    private final RoleRepository serviceBD;
    private final ModelMapper mapper;

    public ManageRoleGatewayImplAdapter(RoleRepository serviceBD,
                                        ModelMapper mapper){
        this.serviceBD = serviceBD;
        this.mapper = mapper;
    }

    @Override
    public List<Role> findAll() {
        Iterable<RoleEntity> dataFromBD = this.serviceBD.findAll();
        List<Role> response = this.mapper.map(dataFromBD, new TypeToken<List<Role>>(){}.getType());
        return response;
    }

    @Override
    public Role save(Role role) {
        RoleEntity roleToSave = this.mapper.map(role, RoleEntity.class);
        RoleEntity roleSaved = this.serviceBD.save(roleToSave);
        Role response = this.mapper.map(roleSaved, Role.class);
        return response;
    }

    @Override
    public Role findByIdRole(long idRole) {
        RoleEntity dataFromBD = this.serviceBD.findById(idRole).get();
        Role response = this.mapper.map(dataFromBD, Role.class);
        return response;
    }

    @Override
    public void deleteRole(Role Role) {
        RoleEntity roleToDelete = this.mapper.map(Role, RoleEntity.class);
        this.serviceBD.delete(roleToDelete);
    }

    @Override
    public List<Permission> findAllPermissions() {
        List<PermissionEntity> dataFromBD = this.serviceBD.findAllPermissions();
        List<Permission> response = this.mapper.map(dataFromBD, new TypeToken<List<Permission>>(){}.getType());
        return response;
    }

    @Override
    public boolean existsByTypeRole(String typeRole) {
        return this.serviceBD.existsByTypeRole(typeRole);
    }

    @Override
    public boolean existsById(long idRole) {
        return this.serviceBD.existsById(idRole);
    }
    
}
