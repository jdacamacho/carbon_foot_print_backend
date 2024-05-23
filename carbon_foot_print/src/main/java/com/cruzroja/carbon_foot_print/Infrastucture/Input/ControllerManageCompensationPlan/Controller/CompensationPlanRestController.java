package com.cruzroja.carbon_foot_print.Infrastucture.Input.ControllerManageCompensationPlan.Controller;

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
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cruzroja.carbon_foot_print.Application.Input.ManageCompensationPlanCUIntPort;
import com.cruzroja.carbon_foot_print.Domain.Models.CompensationPlan;
import com.cruzroja.carbon_foot_print.Infrastucture.Input.ControllerManageCompensationPlan.DTORequest.CompensationPlanDTORequest;
import com.cruzroja.carbon_foot_print.Infrastucture.Input.ControllerManageCompensationPlan.DTORequest.CompensationPlanWithIdDTORequest;
import com.cruzroja.carbon_foot_print.Infrastucture.Input.ControllerManageCompensationPlan.DTOResponse.CompensationPlanDTOResponse;
import com.cruzroja.carbon_foot_print.Infrastucture.Input.ControllerManageCompensationPlan.mapper.MapperCompensationPlanInfrasctuctureDomain;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@CrossOrigin(origins = { "http://localhost:5050" })
@RestController
@RequestMapping("/api/plans")
@Validated
@RequiredArgsConstructor
public class CompensationPlanRestController {
    private final ManageCompensationPlanCUIntPort compensationPlanCU;
    private final MapperCompensationPlanInfrasctuctureDomain mapper;

    @GetMapping("")
    @Transactional(readOnly = true)
    public ResponseEntity<List<CompensationPlanDTOResponse>> listCompensationPlan(){
        List<CompensationPlan> plans = this.compensationPlanCU.finAllCompensationPlan();
        ResponseEntity<List<CompensationPlanDTOResponse>> objResponse = new ResponseEntity<List<CompensationPlanDTOResponse>>(
            mapper.mapModelsToResponse(plans),HttpStatus.OK);
        return objResponse;
    }

    @GetMapping("/id/{planId}")
    @Transactional(readOnly = true)
    public ResponseEntity<CompensationPlanDTOResponse> getCompensationPlanById(@PathVariable long planId){
        CompensationPlan plan = this.compensationPlanCU.findByCompensationPlanId(planId);
        ResponseEntity<CompensationPlanDTOResponse> objResponse = new ResponseEntity<CompensationPlanDTOResponse>(
            mapper.mapModelToResponse(plan) ,HttpStatus.OK);
        return objResponse;
    }

    @GetMapping("/name")
    @Transactional(readOnly = true)
    public ResponseEntity<CompensationPlanDTOResponse> getCompensationPlanByName(@RequestParam String planName){
        CompensationPlan plan = this.compensationPlanCU.findByCompesationPlanName(planName);
        ResponseEntity<CompensationPlanDTOResponse> objResponse = new ResponseEntity<CompensationPlanDTOResponse>(
            mapper.mapModelToResponse(plan) ,HttpStatus.OK);
        return objResponse;
    }

    @PostMapping("")
    public ResponseEntity<?> saveCompensationPlan(@Valid @RequestBody CompensationPlanDTORequest request , BindingResult result){
        CompensationPlan plan = this.mapper.mapRequestToModel(request);
        Map<String, Object> response = new HashMap<>();
        CompensationPlanDTOResponse objPlan;

        if (result.hasErrors()) {
            List<String> listaErrores = new ArrayList<>();

            for (FieldError error : result.getFieldErrors()) {
                listaErrores.add("The field '" + error.getField() + "‘ " + error.getDefaultMessage());
            }

            response.put("errors", listaErrores);
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.BAD_REQUEST);
        }

        try {
            objPlan = this.mapper.mapModelToResponse(this.compensationPlanCU.saveCompensationPlan(plan));
        } catch (DataAccessException e) {
            response.put("mensaje", "Error when inserting into database");
            response.put("error", e.getMessage() + "" + e.getMostSpecificCause().getMessage());
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return new ResponseEntity<CompensationPlanDTOResponse>(objPlan, HttpStatus.CREATED);
    }

    @PutMapping("")
    public ResponseEntity<?> updateCompensationPlan(@Valid @RequestBody CompensationPlanWithIdDTORequest request , BindingResult result){
        CompensationPlan plan = this.mapper.mapRequestToModel(request);
        Map<String, Object> response = new HashMap<>();
        CompensationPlanDTOResponse objPlan;

        if (result.hasErrors()) {
            List<String> listaErrores = new ArrayList<>();

            for (FieldError error : result.getFieldErrors()) {
                listaErrores.add("The field '" + error.getField() + "‘ " + error.getDefaultMessage());
            }

            response.put("errors", listaErrores);
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.BAD_REQUEST);
        }

        try {
            objPlan = this.mapper.mapModelToResponse(this.compensationPlanCU.saveCompensationPlan(plan));
        } catch (DataAccessException e) {
            response.put("mensaje", "Error when updating into database");
            response.put("error", e.getMessage() + "" + e.getMostSpecificCause().getMessage());
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return new ResponseEntity<CompensationPlanDTOResponse>(objPlan, HttpStatus.CREATED);
    }

}
