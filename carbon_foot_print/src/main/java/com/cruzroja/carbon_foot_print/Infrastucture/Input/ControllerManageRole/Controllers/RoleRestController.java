package com.cruzroja.carbon_foot_print.Infrastucture.Input.ControllerManageRole.Controllers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cruzroja.carbon_foot_print.Application.Input.ManageRoleCUIntPort;
import com.cruzroja.carbon_foot_print.Domain.Models.Role;
import com.cruzroja.carbon_foot_print.Infrastucture.Input.ControllerManageRole.DTORequest.RoleDTORequest;
import com.cruzroja.carbon_foot_print.Infrastucture.Input.ControllerManageRole.DTOResponse.RoleDTOResponse;
import com.cruzroja.carbon_foot_print.Infrastucture.Input.ControllerManageRole.mappers.MapperRoleInfrastuctureDomain;

import jakarta.validation.Valid;
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

    @GetMapping("/roles/idRole/{idRole}")
    @Transactional(readOnly = true)
    public ResponseEntity<RoleDTOResponse> getRole(@PathVariable long idRole){
        Role role = this.roleCU.getRole(idRole);
        ResponseEntity<RoleDTOResponse> objResponse = new ResponseEntity<RoleDTOResponse>(
            mapper.mapModelToResponse(role),HttpStatus.OK);
        return objResponse;
    }

    @PostMapping("/roles")
    public ResponseEntity<?> saveRole(@Valid @RequestBody RoleDTORequest roleRequest, BindingResult result){
        Role role = this.mapper.mapRequestRoModel(roleRequest);
        Map<String, Object> response = new HashMap<>();
        RoleDTOResponse objRole;

        if(result.hasErrors()){
			List<String> listaErrores= new ArrayList<>();

			for (FieldError error : result.getFieldErrors()) {
				listaErrores.add("The field '" + error.getField() +"‘ "+ error.getDefaultMessage());
			}

			response.put("errors", listaErrores);
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.BAD_REQUEST);
		}

        try {
            objRole = this.mapper.mapModelToResponse(this.roleCU.saveRole(role));
        } catch (DataAccessException e) {
            response.put("mensaje", "Error when inserting into database");
			response.put("error", e.getMessage() + "" + e.getMostSpecificCause().getMessage());
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return new ResponseEntity<RoleDTOResponse>(objRole, HttpStatus.OK);
    }

    @PutMapping("/roles")
    public ResponseEntity<?> updateRole(@Valid @RequestBody RoleDTORequest roleRequest, BindingResult result){
        Role role = this.mapper.mapRequestRoModel(roleRequest);
        Map<String, Object> response = new HashMap<>();
        RoleDTOResponse objRole;

        if(result.hasErrors()){
			List<String> listaErrores= new ArrayList<>();

			for (FieldError error : result.getFieldErrors()) {
				listaErrores.add("The field '" + error.getField() +"‘ "+ error.getDefaultMessage());
			}

			response.put("errors", listaErrores);
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.BAD_REQUEST);
		}

        try {
            objRole = this.mapper.mapModelToResponse(this.roleCU.updateRole(role));
        } catch (DataAccessException e) {
            response.put("mensaje", "Error when updating into database");
			response.put("error", e.getMessage() + "" + e.getMostSpecificCause().getMessage());
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return new ResponseEntity<RoleDTOResponse>(objRole, HttpStatus.OK);
    }
    
}
