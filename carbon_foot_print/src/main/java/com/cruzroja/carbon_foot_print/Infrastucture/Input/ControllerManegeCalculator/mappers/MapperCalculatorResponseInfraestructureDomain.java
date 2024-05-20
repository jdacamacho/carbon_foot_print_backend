package com.cruzroja.carbon_foot_print.Infrastucture.Input.ControllerManegeCalculator.mappers;

import java.util.List;

import org.mapstruct.Mapper;

import com.cruzroja.carbon_foot_print.Domain.Calculator.CalculatorResponse;
import com.cruzroja.carbon_foot_print.Infrastucture.Input.ControllerManegeCalculator.DTOResponse.CalculatorResponseDTOResponse;

@Mapper(componentModel = "spring")
public interface MapperCalculatorResponseInfraestructureDomain {
    CalculatorResponseDTOResponse modelToResponse(CalculatorResponse model);

    List<CalculatorResponseDTOResponse> modelsToResponses(List<CalculatorResponse> models);
}
