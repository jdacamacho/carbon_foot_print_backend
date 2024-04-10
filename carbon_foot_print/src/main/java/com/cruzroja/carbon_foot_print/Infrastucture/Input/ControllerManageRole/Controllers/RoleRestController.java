package com.cruzroja.carbon_foot_print.Infrastucture.Input.ControllerManageRole.Controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cruzroja.carbon_foot_print.Application.Input.ManageRoleCUIntPort;
import com.cruzroja.carbon_foot_print.Domain.Models.Role;
import com.cruzroja.carbon_foot_print.Infrastucture.Input.ControllerManageRole.DTOResponse.RoleDTOResponse;
import com.cruzroja.carbon_foot_print.Infrastucture.Input.ControllerManageRole.mappers.MapperRoleInfrastuctureDomain;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/apiRole")
@Validated
@RequiredArgsConstructor
public class RoleRestController {
    private final ManageRoleCUIntPort roleCU;
    private final MapperRoleInfrastuctureDomain mapper;

    @GetMapping("/roles")
    @Transactional(readOnly = true)
    public ResponseEntity<List<RoleDTOResponse>> listRoles(){
        List<Role> roles = this.roleCU.listRoles();
        ResponseEntity<List<RoleDTOResponse>> objResponse = new ResponseEntity<List<RoleDTOResponse>>(
            mapper.mapModelsToResponse(roles),HttpStatus.OK);
        return objResponse;
    }
    
}
