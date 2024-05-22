package com.cruzroja.carbon_foot_print.Infrastucture.Input.ControllerManageSource.Controllers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
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

import com.cruzroja.carbon_foot_print.Application.Input.ManageSourceCUIntPort;
import com.cruzroja.carbon_foot_print.Domain.Models.Source;
import com.cruzroja.carbon_foot_print.Infrastucture.Input.ControllerManageSource.DTORequest.SourceDTORequest;
import com.cruzroja.carbon_foot_print.Infrastucture.Input.ControllerManageSource.DTORequest.SourceWithIdDTORequest;
import com.cruzroja.carbon_foot_print.Infrastucture.Input.ControllerManageSource.DTOResponse.SourceDTOResponse;
import com.cruzroja.carbon_foot_print.Infrastucture.Input.ControllerManageSource.mappers.MapperSourceInfrastuctureDomain;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@CrossOrigin(origins = { "http://localhost:5050" })
@RestController
@RequestMapping("/api/sources")
@Validated
@RequiredArgsConstructor
public class SourceRestController {
    private final ManageSourceCUIntPort sourceCU;
    private final MapperSourceInfrastuctureDomain mapper;

    @GetMapping("")
    @Transactional(readOnly = true)
    @PreAuthorize("hasRole('Listar_Fuentes')")
    public ResponseEntity<List<SourceDTOResponse>> listSources() {
        List<Source> sources = this.sourceCU.listSources();
        ResponseEntity<List<SourceDTOResponse>> objResponse = new ResponseEntity<List<SourceDTOResponse>>(
                mapper.mapModelsToResponse(sources), HttpStatus.OK);
        return objResponse;
    }

    @GetMapping("/{idSource}")
    @Transactional(readOnly = true)
    @PreAuthorize("hasRole('Consultar_Fuente_ID')")
    public ResponseEntity<SourceDTOResponse> findSourceById(@PathVariable long idSource) {
        Source source = this.sourceCU.findByIdSource(idSource);
        ResponseEntity<SourceDTOResponse> objResponse = new ResponseEntity<SourceDTOResponse>(
                mapper.mapModelToTesponse(source), HttpStatus.OK);
        return objResponse;
    }

    @GetMapping("/sourceName")
    @Transactional(readOnly = true)
    @PreAuthorize("hasRole('Consultar_Fuente_name')")
    public ResponseEntity<SourceDTOResponse> findSourceByName(@RequestParam String sourceName) {
        Source source = this.sourceCU.findBySourceName(sourceName);
        ResponseEntity<SourceDTOResponse> objResponse = new ResponseEntity<SourceDTOResponse>(
                mapper.mapModelToTesponse(source), HttpStatus.OK);
        return objResponse;
    }

    @PostMapping("")
    @PreAuthorize("hasRole('Crear_Fuente')")
    public ResponseEntity<?> saveSource(@Valid @RequestBody SourceDTORequest request, BindingResult result) {
        Source source = this.mapper.mapRequestToModel(request);
        Map<String, Object> response = new HashMap<>();
        SourceDTOResponse objResource;

        if (result.hasErrors()) {
            List<String> listaErrores = new ArrayList<>();

            for (FieldError error : result.getFieldErrors()) {
                listaErrores.add("The field '" + error.getField() + "‘ " + error.getDefaultMessage());
            }

            response.put("errors", listaErrores);
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.BAD_REQUEST);
        }

        try {
            objResource = this.mapper.mapModelToTesponse(this.sourceCU.saveSource(source));

        } catch (DataAccessException e) {
            response.put("mensaje", "Error when inserting into database");
            response.put("error", e.getMessage() + "" + e.getMostSpecificCause().getMessage());
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return new ResponseEntity<SourceDTOResponse>(objResource, HttpStatus.CREATED);
    }

    @PutMapping("")
    @PreAuthorize("hasRole('Actualizar_Fuente')")
    public ResponseEntity<?> updateSource(@Valid @RequestBody SourceWithIdDTORequest request, BindingResult result) {
        Source source = this.mapper.mapRequestWithIdToModel(request);
        Map<String, Object> response = new HashMap<>();
        SourceDTOResponse objResource;

        if (result.hasErrors()) {
            List<String> listaErrores = new ArrayList<>();

            for (FieldError error : result.getFieldErrors()) {
                listaErrores.add("The field '" + error.getField() + "‘ " + error.getDefaultMessage());
            }

            response.put("errors", listaErrores);
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.BAD_REQUEST);
        }

        try {
            objResource = this.mapper.mapModelToTesponse(this.sourceCU.updateSource(source));

        } catch (DataAccessException e) {
            response.put("mensaje", "Error when updating into database");
            response.put("error", e.getMessage() + "" + e.getMostSpecificCause().getMessage());
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return new ResponseEntity<SourceDTOResponse>(objResource, HttpStatus.OK);
    }
}
