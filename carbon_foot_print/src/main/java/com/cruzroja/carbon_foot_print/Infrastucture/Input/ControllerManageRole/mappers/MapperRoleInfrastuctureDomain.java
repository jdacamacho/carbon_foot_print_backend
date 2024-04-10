package com.cruzroja.carbon_foot_print.Infrastucture.Input.ControllerManageRole.mappers;

import java.util.List;

import org.mapstruct.Mapper;

import com.cruzroja.carbon_foot_print.Domain.Models.Permission;
import com.cruzroja.carbon_foot_print.Domain.Models.Role;
import com.cruzroja.carbon_foot_print.Infrastucture.Input.ControllerManageRole.DTORequest.RoleDTORequest;
import com.cruzroja.carbon_foot_print.Infrastucture.Input.ControllerManageRole.DTOResponse.PermissionDTOResponse;
import com.cruzroja.carbon_foot_print.Infrastucture.Input.ControllerManageRole.DTOResponse.RoleDTOResponse;

@Mapper(componentModel = "spring")
public interface MapperRoleInfrastuctureDomain {
    Role mapRequestRoModel(RoleDTORequest request);
    RoleDTOResponse mapModelToResponse(Role model);
    List<RoleDTOResponse> mapModelsToResponse(List<Role> roles); 
    List<PermissionDTOResponse> mapModelsPermissionToResponse(List<Permission> permissions);
}
