package com.cruzroja.carbon_foot_print.Infrastucture.Input.ControllerManageCompanyPlan.Controller;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

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

import com.cruzroja.carbon_foot_print.Application.Input.ManageCompanyPlanCUIntPort;
import com.cruzroja.carbon_foot_print.Infrastucture.Input.ControllerManageCompanyPlan.DTORequest.CompanyPlanDTORequest;
import com.cruzroja.carbon_foot_print.Infrastucture.Input.ControllerManageCompanyPlan.DTOResponse.CompanyPlanDTOResponse;
import com.cruzroja.carbon_foot_print.Infrastucture.Input.ControllerManageCompanyPlan.mapper.MapperCompanyPlanInfraestructureDomain;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@CrossOrigin(origins = { "http://localhost:5050" })
@RestController
@RequestMapping("/api/companies/plans")
@Validated
@RequiredArgsConstructor
public class CompanyPlanRestController {
    private final ManageCompanyPlanCUIntPort companyPlanCU;
    private final MapperCompanyPlanInfraestructureDomain mapper;

    @PostMapping("")
    public ResponseEntity<?> save(@Valid @RequestBody CompanyPlanDTORequest request, BindingResult errors) {
        Map<String, Object> errorResponse = new HashMap<>();
        errorResponse = this.catchErrors(errors);
        if (!errorResponse.isEmpty())
            return new ResponseEntity<Map<String, Object>>(errorResponse, HttpStatus.BAD_REQUEST);
        try {
            CompanyPlanDTOResponse response = this.mapper.mapDomainToInfraestructure(
                    this.companyPlanCU.save(request.getCompanyNit(), request.getSellerId(), request.getPlanId()));
            return new ResponseEntity<CompanyPlanDTOResponse>(response, HttpStatus.CREATED);
        } catch (DataAccessException e) {
            errorResponse.put("mensaje", "Error when inserting into database");
            errorResponse.put("error", e.getMessage() + "" + e.getMostSpecificCause().getMessage());
            return new ResponseEntity<Map<String, Object>>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    private Map<String, Object> catchErrors(BindingResult result) {
        Map<String, Object> response = new HashMap<>();
        if (result.hasErrors()) {
            List<String> listaErrores = new ArrayList<>();

            for (FieldError error : result.getFieldErrors()) {
                listaErrores.add("The field '" + error.getField() + "‘ " + error.getDefaultMessage());
            }
            response.put("errors", listaErrores);
        }
        return response;

    }
}
