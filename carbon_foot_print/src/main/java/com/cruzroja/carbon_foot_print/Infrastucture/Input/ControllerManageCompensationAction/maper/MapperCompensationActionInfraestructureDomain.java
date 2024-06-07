package com.cruzroja.carbon_foot_print.Infrastucture.Input.ControllerManageCompensationAction.maper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

import com.cruzroja.carbon_foot_print.Domain.CompansationPlan.CompensationMiddleWare;
import com.cruzroja.carbon_foot_print.Infrastucture.Input.ControllerManageCompensationAction.DTORequest.CompensationActionDTORequest;
import com.cruzroja.carbon_foot_print.Infrastucture.Input.ControllerManageCompensationAction.DTORequest.CompensationActionWithIdDTORequest;
import com.cruzroja.carbon_foot_print.Infrastucture.Input.ControllerManageCompensationAction.DTOResponse.CompensationActionDTOResponse;

@Mapper(componentModel = "spring")
public interface MapperCompensationActionInfraestructureDomain {

    CompensationMiddleWare mapInfraestructureToModel(CompensationActionDTORequest request);

    CompensationMiddleWare mapInfraestructureToModel(CompensationActionWithIdDTORequest request);

    @Mapping(source = "model.plan.volunteer.documentNumber", target = "plan.volunteerId")
    CompensationActionDTOResponse mapModelToinfraestructure(CompensationMiddleWare model);

    List<CompensationActionDTOResponse> mapModelToinfraestructure(List<CompensationMiddleWare> model);

}
