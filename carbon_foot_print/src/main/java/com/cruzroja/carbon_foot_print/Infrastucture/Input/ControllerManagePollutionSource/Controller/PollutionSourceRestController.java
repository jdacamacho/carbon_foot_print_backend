package com.cruzroja.carbon_foot_print.Infrastucture.Input.ControllerManagePollutionSource.Controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cruzroja.carbon_foot_print.Application.Input.ManagePollutionSourceIntPort;
import com.cruzroja.carbon_foot_print.Domain.Models.PollutionSource;
import com.cruzroja.carbon_foot_print.Infrastucture.Input.ControllerManagePollutionSource.DTORequest.PollutionSourceIdDTORequest;
import com.cruzroja.carbon_foot_print.Infrastucture.Input.ControllerManagePollutionSource.DTOResponse.PollutionSourceDTOResponse;
import com.cruzroja.carbon_foot_print.Infrastucture.Input.ControllerManagePollutionSource.mappers.MapperPollutionSourceInfrastuctureDomain;

import lombok.RequiredArgsConstructor;

@CrossOrigin(origins = {"http://localhost:5050"})
@RestController
@RequestMapping("/api/pollution/sources")
@Validated
@RequiredArgsConstructor
public class PollutionSourceRestController {
    private final ManagePollutionSourceIntPort pollutionSourceCU;
    private final MapperPollutionSourceInfrastuctureDomain mapper;

    @GetMapping("")
    @Transactional(readOnly = true)
    public ResponseEntity<List<PollutionSourceDTOResponse>> listPollutionSources(){
        List<PollutionSource> pollutionSources = this.pollutionSourceCU.listPollutionSources();
        ResponseEntity<List<PollutionSourceDTOResponse>> objResponse = new ResponseEntity<List<PollutionSourceDTOResponse>>(
            mapper.mapModelToResponse(pollutionSources) ,HttpStatus.OK);
        return objResponse;
    } 

    @GetMapping("/id")
    @Transactional(readOnly = true)
    public ResponseEntity<PollutionSourceDTOResponse> getPollutionSources(@RequestBody PollutionSourceIdDTORequest request){
        PollutionSource source = this.pollutionSourceCU.findById(request.getIdPollution(), request.getIdSource());
        ResponseEntity<PollutionSourceDTOResponse> objResponse = new ResponseEntity<PollutionSourceDTOResponse>(
            mapper.mapModelToResponse(source) ,HttpStatus.OK);
        return objResponse;
    } 
}
