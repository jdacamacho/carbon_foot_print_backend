package com.cruzroja.carbon_foot_print.Infrastucture.Input.ControllerManagePollutionType.Controllers;

import com.cruzroja.carbon_foot_print.Application.Input.ManagePollutionTypeCUIntPort;
import com.cruzroja.carbon_foot_print.Domain.Models.PollutionType;
import com.cruzroja.carbon_foot_print.Infrastucture.Input.ControllerManagePollutionType.DTOResponse.PollutionTypeDTOResponse;
import com.cruzroja.carbon_foot_print.Infrastucture.Input.ControllerManagePollutionType.mappers.MapperPollutionTypeInfraestructureDomain;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    public ResponseEntity<PollutionTypeDTOResponse> savePollutionType(@Valid @RequestBody PollutionType pollutionType) {
        PollutionType savedPollutionType = managePollutionTypeCU.savePollutionType(pollutionType);
        PollutionTypeDTOResponse response = mapper.toPollutionTypeDTOResponse(savedPollutionType);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @PutMapping("/{pollutionTypeId}")
    public ResponseEntity<PollutionTypeDTOResponse> updatePollutionType(@PathVariable long pollutionTypeId,
            @Valid @RequestBody PollutionType pollutionType) {
        // pollutionType.setId(pollutionTypeId);
        PollutionType updatedPollutionType = managePollutionTypeCU.updatePollutionType(pollutionType);
        PollutionTypeDTOResponse response = mapper.toPollutionTypeDTOResponse(updatedPollutionType);
        return ResponseEntity.ok(response);
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
}
