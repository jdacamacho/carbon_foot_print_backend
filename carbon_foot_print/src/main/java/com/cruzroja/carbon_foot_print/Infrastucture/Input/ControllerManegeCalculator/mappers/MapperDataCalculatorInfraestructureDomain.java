package com.cruzroja.carbon_foot_print.Infrastucture.Input.ControllerManegeCalculator.mappers;

import java.util.List;

import org.mapstruct.Mapper;

import com.cruzroja.carbon_foot_print.Domain.Models.DataCalculator;
import com.cruzroja.carbon_foot_print.Infrastucture.Input.ControllerManegeCalculator.DTORequest.DataCalculatorDTORequest;

@Mapper(componentModel = "spring")
public interface MapperDataCalculatorInfraestructureDomain {
    DataCalculator requestToModel(DataCalculatorDTORequest request);

    List<DataCalculator> requestsToModels(List<DataCalculatorDTORequest> requests);
}