package com.cruzroja.carbon_foot_print.Infrastucture.Input.ControllerManegeCalculator.Controllers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

import com.cruzroja.carbon_foot_print.Domain.Models.DataCalculator;
import com.cruzroja.carbon_foot_print.Domain.UserCases.ManegeCalculatorCUImplAdapter;
import com.cruzroja.carbon_foot_print.Infrastucture.Input.ControllerManegeCalculator.DTORequest.DataCalculatorDTORequest;
import com.cruzroja.carbon_foot_print.Infrastucture.Input.ControllerManegeCalculator.DTORequest.DataCalculatorListDTORequest;
import com.cruzroja.carbon_foot_print.Infrastucture.Input.ControllerManegeCalculator.DTOResponse.CalculatorResponseDTOResponse;
import com.cruzroja.carbon_foot_print.Infrastucture.Input.ControllerManegeCalculator.mappers.MapperCalculatorResponseInfraestructureDomain;
import com.cruzroja.carbon_foot_print.Infrastucture.Input.ControllerManegeCalculator.mappers.MapperDataCalculatorInfraestructureDomain;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@CrossOrigin(origins = { "http://localhost:5050" })
@RestController
@RequestMapping("/api/public/calculator")
@Validated
@RequiredArgsConstructor
public class CalculatorRestController {

    private final ManegeCalculatorCUImplAdapter calculatorCU;
    private final MapperDataCalculatorInfraestructureDomain mapperData;
    private final MapperCalculatorResponseInfraestructureDomain mapperResponse;

    @PostMapping
    public ResponseEntity<?> calcule(@RequestBody List<DataCalculatorDTORequest> request, BindingResult errors) {
        List<DataCalculator> data = this.mapperData.requestsToModels(request);
        Map<String, Object> errorResponse = new HashMap<>();
        errorResponse = this.catchErrors(errors);
        if (!errorResponse.isEmpty())
            return new ResponseEntity<Map<String, Object>>(errorResponse, HttpStatus.BAD_REQUEST);
        try {
            CalculatorResponseDTOResponse response = this.mapperResponse
                    .modelToResponse(this.calculatorCU.calculeFootPrint(data));
            return new ResponseEntity<CalculatorResponseDTOResponse>(response, HttpStatus.ACCEPTED);
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
