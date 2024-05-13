package com.cruzroja.carbon_foot_print.Infrastucture.Input.ControllerManagePollutionType.Controllers;

import com.cruzroja.carbon_foot_print.Application.Input.ManagePollutionTypeCUIntPort;
import com.cruzroja.carbon_foot_print.Domain.Models.PollutionType;
import com.cruzroja.carbon_foot_print.Infrastucture.Input.ControllerManagePollutionType.DTORequest.PollutionTypeDTORequest;
import com.cruzroja.carbon_foot_print.Infrastucture.Input.ControllerManagePollutionType.DTORequest.PollutionTypeWithIdDTORequest;
import com.cruzroja.carbon_foot_print.Infrastucture.Input.ControllerManagePollutionType.DTOResponse.PollutionTypeDTOResponse;
import com.cruzroja.carbon_foot_print.Infrastucture.Input.ControllerManagePollutionType.mappers.MapperPollutionTypeInfraestructureDomain;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin(origins = { "http://localhost:5050" })
@RestController
@RequestMapping("/api/pollutions/types")
@Validated
@RequiredArgsConstructor
public class PollutionTypeRestController {

    private final ManagePollutionTypeCUIntPort managePollutionTypeCU;
    private final MapperPollutionTypeInfraestructureDomain mapper;

    @GetMapping
    public ResponseEntity<List<PollutionTypeDTOResponse>> listPollutionTypes() {
        List<PollutionType> pollutionTypes = managePollutionTypeCU.listPollutionTypes();
        List<PollutionTypeDTOResponse> response = mapper.toPollutionTypeDTOResponseList(pollutionTypes);
        return ResponseEntity.ok(response);
    }

    @PostMapping
    public ResponseEntity<?> savePollutionType(@Valid @RequestBody PollutionTypeDTORequest request,
            BindingResult result) {
        PollutionType model = this.mapper.requestToModel(request);
        Map<String, Object> response = new HashMap<>();
        response = this.catchErrors(result);
        if (response.size() != 0)
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.BAD_REQUEST);
        try {
            PollutionTypeDTOResponse objPollutionType = this.mapper
                    .toPollutionTypeDTOResponse(managePollutionTypeCU.savePollutionType(model));
            return new ResponseEntity<PollutionTypeDTOResponse>(objPollutionType, HttpStatus.CREATED);
        } catch (DataAccessException e) {
            response.put("mensaje", "Error when inserting into database");
            response.put("error", e.getMessage() + "" + e.getMostSpecificCause().getMessage());
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/")
    public ResponseEntity<?> updatePollutionType(
            @Valid @RequestBody PollutionTypeWithIdDTORequest request, BindingResult result) {
        PollutionType model = this.mapper.requestToModel(request);
        Map<String, Object> response = new HashMap<>();
        response = this.catchErrors(result);
        if (response.size() != 0)
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.BAD_REQUEST);
        try {
            PollutionTypeDTOResponse objPollutionType = this.mapper
                    .toPollutionTypeDTOResponse(managePollutionTypeCU.updatePollutionType(model));
            return new ResponseEntity<PollutionTypeDTOResponse>(objPollutionType, HttpStatus.OK);
        } catch (DataAccessException e) {
            response.put("mensaje", "Error when inserting into database");
            response.put("error", e.getMessage() + "" + e.getMostSpecificCause().getMessage());
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{pollutionTypeId}")
    public ResponseEntity<PollutionTypeDTOResponse> findPollutionTypeById(@PathVariable long pollutionTypeId) {
        PollutionType pollutionType = managePollutionTypeCU.getPollutionTypeById(pollutionTypeId);
        PollutionTypeDTOResponse response = mapper.toPollutionTypeDTOResponse(pollutionType);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/name")
    public ResponseEntity<List<PollutionTypeDTOResponse>> findPollutionTypeByName(@RequestParam("name") String name) {
        List<PollutionType> pollutionTypes = managePollutionTypeCU.getPollutionTypeByName(name);
        List<PollutionTypeDTOResponse> response = mapper.toPollutionTypeDTOResponseList(pollutionTypes);
        return ResponseEntity.ok(response);
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
