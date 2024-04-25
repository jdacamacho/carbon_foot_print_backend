package com.cruzroja.carbon_foot_print.Infrastucture.Input.ControllerManageAuth.Controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cruzroja.carbon_foot_print.Application.Input.ManageAuthCUIntPort;
import com.cruzroja.carbon_foot_print.Domain.Models.Credential;
import com.cruzroja.carbon_foot_print.Infrastucture.Input.ControllerManageAuth.DTORequest.LoginDTORequest;
import com.cruzroja.carbon_foot_print.Infrastucture.Input.ControllerManageAuth.DTOResponse.CredentialDTOResponse;
import com.cruzroja.carbon_foot_print.Infrastucture.Input.ControllerManageAuth.mappers.MapperCredentialInfrastuctureDomain;


import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@CrossOrigin(origins = {"http://localhost:5050"})
@RestController
@RequestMapping("/api/auth")
@Validated
@RequiredArgsConstructor
public class AuthRestController {
    private final ManageAuthCUIntPort authCU;
    private final  MapperCredentialInfrastuctureDomain mapper;

    @PostMapping("")
    public ResponseEntity<?> login(@Valid @RequestBody LoginDTORequest request, BindingResult result){
        Map<String,Object>  response = new HashMap<>();
        CredentialDTOResponse objCredentials;

        if(result.hasErrors()){
			List<String> listaErrores= new ArrayList<>();

			for (FieldError error : result.getFieldErrors()) {
				listaErrores.add("The field '" + error.getField() +"‘ "+ error.getDefaultMessage());
			}

			response.put("errors", listaErrores);
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.BAD_REQUEST);
		}

        try{
            Credential credential = this.authCU.login(request.getUsername(), request.getPassword());
            objCredentials = this.mapper.mapModelToResponse(credential);
        }catch(DataAccessException e){
            response.put("mensaje", "Error login in DB");
			response.put("error", e.getMessage() + "" + e.getMostSpecificCause().getMessage());
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return new ResponseEntity<CredentialDTOResponse>(objCredentials,HttpStatus.OK);
    }

}
