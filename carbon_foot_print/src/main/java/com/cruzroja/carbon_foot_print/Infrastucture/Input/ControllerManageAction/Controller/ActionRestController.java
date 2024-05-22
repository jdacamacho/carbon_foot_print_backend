package com.cruzroja.carbon_foot_print.Infrastucture.Input.ControllerManageAction.Controller;

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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cruzroja.carbon_foot_print.Application.Input.ManageActionCUIntPort;
import com.cruzroja.carbon_foot_print.Domain.Models.Action;
import com.cruzroja.carbon_foot_print.Infrastucture.Input.ControllerManageAction.DTORequest.ActionDTORequest;
import com.cruzroja.carbon_foot_print.Infrastucture.Input.ControllerManageAction.DTORequest.ActionWithIdDTORequest;
import com.cruzroja.carbon_foot_print.Infrastucture.Input.ControllerManageAction.DTOResponse.ActionDTOResponse;
import com.cruzroja.carbon_foot_print.Infrastucture.Input.ControllerManageAction.mapper.MapperActionInfrastuctureDomain;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@CrossOrigin(origins = { "http://localhost:5050" })
@RestController
@RequestMapping("/api/actions")
@Validated
@RequiredArgsConstructor
public class ActionRestController {
    private final ManageActionCUIntPort actionCU;
    private final MapperActionInfrastuctureDomain mapper; 

    @GetMapping("")
    @Transactional(readOnly = true)
    public ResponseEntity<List<ActionDTOResponse>> listActions(){
        List<Action> actions = this.actionCU.findAllActions();
        ResponseEntity<List<ActionDTOResponse>> objResponse = new ResponseEntity<List<ActionDTOResponse>>(
            mapper.mapModelsToResponse(actions), HttpStatus.OK  
        );
        return objResponse;
    }

    @GetMapping("/id/{idAction}")
    @Transactional(readOnly = true)
    public ResponseEntity<ActionDTOResponse> getActionById(@PathVariable long idAction){
        Action action = this.actionCU.findActionById(idAction);
        ResponseEntity<ActionDTOResponse> objResponse = new ResponseEntity<ActionDTOResponse>(
            mapper.mapModelToResponse(action), HttpStatus.OK  
        );
        return objResponse;
    }

    @GetMapping("/name")
    @Transactional(readOnly = true)
    public ResponseEntity<ActionDTOResponse> getActionByName(@RequestParam String actionName){
        Action action = this.actionCU.findActionByName(actionName);
        ResponseEntity<ActionDTOResponse> objResponse = new ResponseEntity<ActionDTOResponse>(
            mapper.mapModelToResponse(action), HttpStatus.OK  
        );
        return objResponse;
    }

    @PostMapping
    public ResponseEntity<?> saveAction(@Valid @RequestBody ActionDTORequest request , BindingResult result){
        Action action = this.mapper.mapRequestToModel(request);
        Map<String, Object> response = new HashMap<>();
        ActionDTOResponse objAction;

        if (result.hasErrors()) {
            List<String> listaErrores = new ArrayList<>();

            for (FieldError error : result.getFieldErrors()) {
                listaErrores.add("The field '" + error.getField() + "‘ " + error.getDefaultMessage());
            }

            response.put("errors", listaErrores);
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.BAD_REQUEST);
        }

        try {
            objAction = this.mapper.mapModelToResponse(this.actionCU.saveAction(action));
        } catch (DataAccessException e) {
            response.put("mensaje", "Error when inserting into database");
            response.put("error", e.getMessage() + "" + e.getMostSpecificCause().getMessage());
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return new ResponseEntity<ActionDTOResponse>(objAction, HttpStatus.CREATED);
    }

    @PostMapping
    public ResponseEntity<?> updateAction(@Valid @RequestBody ActionWithIdDTORequest request , BindingResult result){
        Action action = this.mapper.mapRequestToModel(request);
        Map<String, Object> response = new HashMap<>();
        ActionDTOResponse objAction;

        if (result.hasErrors()) {
            List<String> listaErrores = new ArrayList<>();

            for (FieldError error : result.getFieldErrors()) {
                listaErrores.add("The field '" + error.getField() + "‘ " + error.getDefaultMessage());
            }

            response.put("errors", listaErrores);
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.BAD_REQUEST);
        }

        try {
            objAction = this.mapper.mapModelToResponse(this.actionCU.updateAction(action));
        } catch (DataAccessException e) {
            response.put("mensaje", "Error when updating into database");
            response.put("error", e.getMessage() + "" + e.getMostSpecificCause().getMessage());
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return new ResponseEntity<ActionDTOResponse>(objAction, HttpStatus.OK );
    }

    
}
