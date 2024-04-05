package com.cruzroja.carbon_foot_print.Infrastucture.Input.ControllerManageUserCompany.Controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cruzroja.carbon_foot_print.Application.Input.ManageUserCompanyCUIntPort;
import com.cruzroja.carbon_foot_print.Domain.Models.UserCompany;
import com.cruzroja.carbon_foot_print.Infrastucture.Input.ControllerManageUserCompany.DTOResponse.UserCompanyDTOResponse;
import com.cruzroja.carbon_foot_print.Infrastucture.Input.ControllerManageUserCompany.mappers.MapperUserCompanyInfrastuctureDomain;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;


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
    
}
