package com.cruzroja.carbon_foot_print.Infrastucture.Input.ControllerManegeUserVolunteer.Controllers;

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

import com.cruzroja.carbon_foot_print.Application.Input.ManegeUserVolunteerCUIntPort;
import com.cruzroja.carbon_foot_print.Domain.Models.UserVolunteer;
import com.cruzroja.carbon_foot_print.Infrastucture.Input.ControllerManegeUserVolunteer.mappers.MapperUserVolunteerInfraestructureDomain;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.cruzroja.carbon_foot_print.Infrastucture.Input.ControllerManegeUserVolunteer.DTORequest.UserVolunteerDTORequest;
import com.cruzroja.carbon_foot_print.Infrastucture.Input.ControllerManegeUserVolunteer.DTORequest.UserVolunteerUpdateDTORequest;
import com.cruzroja.carbon_foot_print.Infrastucture.Input.ControllerManegeUserVolunteer.DTOResponse.UserVolunteerDTOResponse;

@CrossOrigin(origins = { "http://localhost:5050" })
@RestController
@RequestMapping("/api/user/volunteers")
@Validated
@RequiredArgsConstructor
public class UserVolunteerRestController {
    private final ManegeUserVolunteerCUIntPort volunteerCU;
    private final MapperUserVolunteerInfraestructureDomain mapper;

    @GetMapping("")
    @Transactional(readOnly = true)
    public ResponseEntity<List<UserVolunteerDTOResponse>> listVolunteers() {
        List<UserVolunteer> volunteers = this.volunteerCU.listUserVolunteers();
        ResponseEntity<List<UserVolunteerDTOResponse>> objResponse = new ResponseEntity<List<UserVolunteerDTOResponse>>(
                this.mapper.mapModelsToResponse(volunteers), HttpStatus.OK);
        return objResponse;
    }

    @GetMapping("/{documentNumber}")
    @Transactional(readOnly = true)
    public ResponseEntity<UserVolunteerDTOResponse> getVolunteer(@PathVariable long documentNumber) {
        UserVolunteer volunteer = this.volunteerCU.getUserVolunteerByNumberDocument(documentNumber);
        ResponseEntity<UserVolunteerDTOResponse> objResponse = new ResponseEntity<UserVolunteerDTOResponse>(
                this.mapper.mapModelToResponse(volunteer), HttpStatus.OK);
        return objResponse;
    }

    @GetMapping("/position")
    @Transactional(readOnly = true)
    public ResponseEntity<List<UserVolunteerDTOResponse>> getVolunteersByPosition(
            @NotEmpty @RequestParam String position) {
        List<UserVolunteer> volunteers = this.volunteerCU.getUserVolunteerByPosition(position);
        ResponseEntity<List<UserVolunteerDTOResponse>> objResponse = new ResponseEntity<List<UserVolunteerDTOResponse>>(
                this.mapper.mapModelsToResponse(volunteers), HttpStatus.OK);
        return objResponse;
    }

    @PostMapping("")
    public ResponseEntity<?> saveVolunteer(@Valid @RequestBody UserVolunteerDTORequest request, BindingResult result) {
        UserVolunteer voluntario = this.mapper.mapRequestModel(request);
        Map<String, Object> response = new HashMap<>();
        UserVolunteerDTOResponse objVolunteer;
        response = this.catchErrors(result);
        if (response.size() != 0)
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.BAD_REQUEST);
        try {
            objVolunteer = this.mapper.mapModelToResponse(this.volunteerCU.saveUserVolunteer(voluntario));
        } catch (DataAccessException e) {
            response.put("mensaje", "Error when inserting into database");
            response.put("error", e.getMessage() + "" + e.getMostSpecificCause().getMessage());
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<UserVolunteerDTOResponse>(objVolunteer, HttpStatus.CREATED);
    }

    @PutMapping("")
    public ResponseEntity<?> updateUserVolunteer(@Valid @RequestBody UserVolunteerUpdateDTORequest request,
            BindingResult result) {
        UserVolunteer volunteer = this.mapper.mapRequestUpdateToModel(request);
        Map<String, Object> response = new HashMap<>();
        UserVolunteerDTOResponse objVolunteer;

        response = this.catchErrors(result);
        if (response.size() != 0)
            new ResponseEntity<Map<String, Object>>(response, HttpStatus.BAD_REQUEST);
        try {
            objVolunteer = this.mapper.mapModelToResponse(this.volunteerCU.updateUserVolunteer(volunteer));
        } catch (DataAccessException e) {
            response.put("mensaje", "Error when inserting into database");
            response.put("error", e.getMessage() + "" + e.getMostSpecificCause().getMessage());
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<UserVolunteerDTOResponse>(objVolunteer, HttpStatus.OK);

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
