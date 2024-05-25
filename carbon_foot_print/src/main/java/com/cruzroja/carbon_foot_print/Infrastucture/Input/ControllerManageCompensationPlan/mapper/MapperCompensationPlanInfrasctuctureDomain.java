package com.cruzroja.carbon_foot_print.Infrastucture.Input.ControllerManageCompensationPlan.mapper;

import java.util.List;

import org.mapstruct.Mapper;

import com.cruzroja.carbon_foot_print.Domain.Models.CompensationPlan;
import com.cruzroja.carbon_foot_print.Infrastucture.Input.ControllerManageCompensationPlan.DTORequest.CompensationPlanDTORequest;
import com.cruzroja.carbon_foot_print.Infrastucture.Input.ControllerManageCompensationPlan.DTORequest.CompensationPlanWithIdDTORequest;
import com.cruzroja.carbon_foot_print.Infrastucture.Input.ControllerManageCompensationPlan.DTOResponse.CompensationPlanDTOResponse;

@Mapper(componentModel = "spring")
public interface MapperCompensationPlanInfrasctuctureDomain {
    CompensationPlan mapRequestToModel(CompensationPlanWithIdDTORequest request);
    CompensationPlan mapRequestToModel(CompensationPlanDTORequest request);
    CompensationPlanDTOResponse mapModelToResponse(CompensationPlan model);
    List<CompensationPlanDTOResponse> mapModelsToResponse(List<CompensationPlan> models);
}