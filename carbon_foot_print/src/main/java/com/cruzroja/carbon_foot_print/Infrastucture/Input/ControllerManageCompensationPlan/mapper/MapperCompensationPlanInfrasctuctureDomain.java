package com.cruzroja.carbon_foot_print.Infrastucture.Input.ControllerManageCompensationPlan.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

import com.cruzroja.carbon_foot_print.Domain.Models.CompensationPlan;
import com.cruzroja.carbon_foot_print.Infrastucture.Input.ControllerManageCompensationPlan.DTORequest.CompensationPlanDTORequest;
import com.cruzroja.carbon_foot_print.Infrastucture.Input.ControllerManageCompensationPlan.DTORequest.CompensationPlanWithIdDTORequest;
import com.cruzroja.carbon_foot_print.Infrastucture.Input.ControllerManageCompensationPlan.DTOResponse.CompensationPlanDTOResponse;

@Mapper(componentModel = "spring")
public interface MapperCompensationPlanInfrasctuctureDomain {
    CompensationPlan mapInfraestructureToModel(CompensationPlanDTORequest request);

    CompensationPlan mapInfraestructureToModel(CompensationPlanWithIdDTORequest request);

    @Mapping(source = "model.volunteer.documentNumber", target = "volunteerId")
    CompensationPlanDTOResponse mapModelToInfraestructure(CompensationPlan model);

    List<CompensationPlanDTOResponse> mapModelToInfraestructure(List<CompensationPlan> models);
}