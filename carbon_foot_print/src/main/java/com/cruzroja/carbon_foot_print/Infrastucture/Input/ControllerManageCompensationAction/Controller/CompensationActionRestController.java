package com.cruzroja.carbon_foot_print.Infrastucture.Input.ControllerManageCompensationAction.Controller;

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

import com.cruzroja.carbon_foot_print.Application.Input.ManageCompensationActionCUIntPort;
import com.cruzroja.carbon_foot_print.Domain.CompansationPlan.CompensationMiddleWare;
import com.cruzroja.carbon_foot_print.Infrastucture.Input.ControllerManageCompensationAction.DTORequest.CompensationActionDTORequest;
import com.cruzroja.carbon_foot_print.Infrastucture.Input.ControllerManageCompensationAction.DTORequest.CompensationActionWithIdDTORequest;
import com.cruzroja.carbon_foot_print.Infrastucture.Input.ControllerManageCompensationAction.DTOResponse.CompensationActionDTOResponse;
import com.cruzroja.carbon_foot_print.Infrastucture.Input.ControllerManageCompensationAction.maper.MapperCompensationActionInfraestructureDomain;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Positive;
import lombok.RequiredArgsConstructor;

@CrossOrigin(origins = { "http://localhost:5050" })
@RestController
@RequestMapping("/api/plans/actions")
@Validated
@RequiredArgsConstructor
public class CompensationActionRestController {
    private final ManageCompensationActionCUIntPort compensationActionCU;
    private final MapperCompensationActionInfraestructureDomain mapper;

    @GetMapping("")
    @Transactional(readOnly = true)
    public ResponseEntity<List<CompensationActionDTOResponse>> listAll() {
        List<CompensationMiddleWare> plans = this.compensationActionCU.findAll();
        ResponseEntity<List<CompensationActionDTOResponse>> response = new ResponseEntity<List<CompensationActionDTOResponse>>(
                mapper.mapModelToinfraestructure(plans), HttpStatus.OK);
        return response;
    }

    @GetMapping("/{planId}")
    @Transactional(readOnly = true)
    public ResponseEntity<CompensationActionDTOResponse> getPlanById(@PathVariable long planId) {
        CompensationMiddleWare plan = this.compensationActionCU.findByPlanId(planId);
        ResponseEntity<CompensationActionDTOResponse> response = new ResponseEntity<CompensationActionDTOResponse>(
                mapper.mapModelToinfraestructure(plan), HttpStatus.OK);
        return response;
    }

    @GetMapping("/default")
    @Transactional(readOnly = true)
    public ResponseEntity<List<CompensationActionDTOResponse>> listDefault() {
        List<CompensationMiddleWare> plans = this.compensationActionCU.findDefault();
        ResponseEntity<List<CompensationActionDTOResponse>> response = new ResponseEntity<List<CompensationActionDTOResponse>>(
                mapper.mapModelToinfraestructure(plans), HttpStatus.OK);
        return response;
    }

    @GetMapping("/custom")
    @Transactional(readOnly = true)
    public ResponseEntity<List<CompensationActionDTOResponse>> listCustomEntity(
            @Valid @Positive(message = "volunteerId must be positive.") @RequestParam long volunteerId) {
        List<CompensationMiddleWare> plans = this.compensationActionCU.findByVolunteer(volunteerId);
        ResponseEntity<List<CompensationActionDTOResponse>> response = new ResponseEntity<List<CompensationActionDTOResponse>>(
                mapper.mapModelToinfraestructure(plans), HttpStatus.OK);
        return response;
    }

    @PostMapping("/custommer")
    public ResponseEntity<?> saveCustommer(
            @Valid @Positive(message = "volunteerId must be positive.") @RequestParam long volunteerId,
            @Valid @RequestBody CompensationActionDTORequest request,
            BindingResult errors) {
        CompensationMiddleWare data = mapper.mapInfraestructureToModel(request);
        Map<String, Object> errorResponse = new HashMap<>();
        errorResponse = this.catchErrors(errors);
        if (!errorResponse.isEmpty())
            return new ResponseEntity<Map<String, Object>>(errorResponse, HttpStatus.BAD_REQUEST);
        try {
            CompensationActionDTOResponse response = mapper
                    .mapModelToinfraestructure(this.compensationActionCU.save(data, false, volunteerId));
            return new ResponseEntity<CompensationActionDTOResponse>(response, HttpStatus.CREATED);
        } catch (DataAccessException e) {
            errorResponse.put("mensaje", "Error when inserting into database");
            errorResponse.put("error", e.getMessage() + "" + e.getMostSpecificCause().getMessage());
            return new ResponseEntity<Map<String, Object>>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/default")
    public ResponseEntity<?> saveDefault(
            @Valid @Positive(message = "volunteerId must be positive.") @RequestParam long volunteerId,
            @Valid @RequestBody CompensationActionDTORequest request,
            BindingResult errors) {
        CompensationMiddleWare data = mapper.mapInfraestructureToModel(request);
        Map<String, Object> errorResponse = new HashMap<>();
        errorResponse = this.catchErrors(errors);
        if (!errorResponse.isEmpty())
            return new ResponseEntity<Map<String, Object>>(errorResponse, HttpStatus.BAD_REQUEST);
        try {
            CompensationActionDTOResponse response = mapper
                    .mapModelToinfraestructure(this.compensationActionCU.save(data, true, volunteerId));
            return new ResponseEntity<CompensationActionDTOResponse>(response, HttpStatus.CREATED);
        } catch (DataAccessException e) {
            errorResponse.put("mensaje", "Error when inserting into database");
            errorResponse.put("error", e.getMessage() + "" + e.getMostSpecificCause().getMessage());
            return new ResponseEntity<Map<String, Object>>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("")
    public ResponseEntity<?> update(
            @Valid @Positive(message = "volunteerId must be positive.") @RequestParam long volunteerId,
            @Valid @RequestBody CompensationActionWithIdDTORequest request,
            BindingResult errors) {
        CompensationMiddleWare data = mapper.mapInfraestructureToModel(request);
        Map<String, Object> errorResponse = new HashMap<>();
        errorResponse = this.catchErrors(errors);
        if (!errorResponse.isEmpty())
            return new ResponseEntity<Map<String, Object>>(errorResponse, HttpStatus.BAD_REQUEST);
        try {
            CompensationActionDTOResponse response = mapper
                    .mapModelToinfraestructure(this.compensationActionCU.update(data, volunteerId));
            return new ResponseEntity<CompensationActionDTOResponse>(response, HttpStatus.OK);
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
