package com.cruzroja.carbon_foot_print.Infrastucture.Input.ControllerManageUserCompany.Controllers;

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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cruzroja.carbon_foot_print.Application.Input.ManageUserCompanyCUIntPort;
import com.cruzroja.carbon_foot_print.Domain.Models.UserCompany;
import com.cruzroja.carbon_foot_print.Infrastucture.Input.ControllerManageUserCompany.DTORequest.UserCompanyDTORequest;
import com.cruzroja.carbon_foot_print.Infrastucture.Input.ControllerManageUserCompany.DTOResponse.UserCompanyDTOResponse;
import com.cruzroja.carbon_foot_print.Infrastucture.Input.ControllerManageUserCompany.mappers.MapperUserCompanyInfrastuctureDomain;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/apiUserCompany")
@Validated
@RequiredArgsConstructor
public class UserCompanyRestController {
    private final ManageUserCompanyCUIntPort userCompanyCU;
    private final MapperUserCompanyInfrastuctureDomain mapper;

    @GetMapping("/companies")
    @Transactional(readOnly = true)
    public ResponseEntity<List<UserCompanyDTOResponse>> listCompanies(){
        List<UserCompany> companies = this.userCompanyCU.listUserCompany();
        ResponseEntity<List<UserCompanyDTOResponse>> objResponse = new ResponseEntity<List<UserCompanyDTOResponse>>(
            mapper.mapModelsToResponse(companies),HttpStatus.OK
        );
        return objResponse;
    }

    @PostMapping("/companies")
    public ResponseEntity<?> saveCompany(@Valid @RequestBody UserCompanyDTORequest companyRequest, BindingResult result){
        UserCompany company = this.mapper.mapRequestToModel(companyRequest);
        Map<String, Object> response = new HashMap<>();
        UserCompanyDTOResponse objCompany;

        if(result.hasErrors()){
			List<String> listaErrores= new ArrayList<>();

			for (FieldError error : result.getFieldErrors()) {
				listaErrores.add("The field '" + error.getField() +"‘ "+ error.getDefaultMessage());
			}

			response.put("errors", listaErrores);
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.BAD_REQUEST);
		}

        try{
            objCompany = this.mapper.mapModelToResponse(this.userCompanyCU.saveUserCompany(company));
            
        }catch(DataAccessException e){
            response.put("mensaje", "Error when inserting into database");
			response.put("error", e.getMessage() + "" + e.getMostSpecificCause().getMessage());
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return new ResponseEntity<UserCompanyDTOResponse>(objCompany,HttpStatus.OK);
    }

    @PutMapping("/companies")
    public ResponseEntity<?> updateCompany(@Valid @RequestBody UserCompanyDTORequest companyRequest, BindingResult result){
        UserCompany company = this.mapper.mapRequestToModel(companyRequest);
        Map<String, Object> response = new HashMap<>();
        UserCompanyDTOResponse objCompany;

        if(result.hasErrors()){
			List<String> listaErrores= new ArrayList<>();

			for (FieldError error : result.getFieldErrors()) {
				listaErrores.add("The field '" + error.getField() +"‘ "+ error.getDefaultMessage());
			}

			response.put("errors", listaErrores);
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.BAD_REQUEST);
		}

        try{
            objCompany = this.mapper.mapModelToResponse(this.userCompanyCU.updateUserCompany(company));
            
        }catch(DataAccessException e){
            response.put("mensaje", "Error when updating into database");
			response.put("error", e.getMessage() + "" + e.getMostSpecificCause().getMessage());
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return new ResponseEntity<UserCompanyDTOResponse>(objCompany,HttpStatus.OK);
    }

    @GetMapping("/companies/nit/{nitCompany}")
    @Transactional(readOnly = true)
    public ResponseEntity<UserCompanyDTOResponse> getCompanyByNit(@PathVariable long nitCompany){
        UserCompany company = this.userCompanyCU.getUserCompanyByNit(nitCompany);
        ResponseEntity<UserCompanyDTOResponse> objResponse = new ResponseEntity<UserCompanyDTOResponse>(
            mapper.mapModelToResponse(company),HttpStatus.OK
        );
        return objResponse;
    }

    @GetMapping("/companies/numberDocument/{numberDocument}")
    @Transactional(readOnly = true)
    public ResponseEntity<UserCompanyDTOResponse> getCompanyByUserCharge(@PathVariable long numberDocument){
        UserCompany company = this.userCompanyCU.getUserCompanyByNumberDocument(numberDocument);
        ResponseEntity<UserCompanyDTOResponse> objResponse = new ResponseEntity<UserCompanyDTOResponse>(
            mapper.mapModelToResponse(company),HttpStatus.OK
        );
        return objResponse;
    }


    
}

