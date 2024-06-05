package com.cruzroja.carbon_foot_print.Infrastucture.Input.ControllerManageCompensationAction.maper;

import org.mapstruct.Mapper;

import java.util.List;

import com.cruzroja.carbon_foot_print.Domain.CompansationPlan.CompensationMiddleWare;
import com.cruzroja.carbon_foot_print.Infrastucture.Input.ControllerManageCompensationAction.DTORequest.CompensationActionDTORequest;
import com.cruzroja.carbon_foot_print.Infrastucture.Input.ControllerManageCompensationAction.DTORequest.CompensationActionWithIdDTORequest;
import com.cruzroja.carbon_foot_print.Infrastucture.Input.ControllerManageCompensationAction.DTOResponse.CompensationActionDTOResponse;

//Todo: eliminar comentario
@Mapper(componentModel = "spring")
public interface MapperCompensationActionInfraestructureDomain {

    CompensationMiddleWare mapInfraestructureToModel(CompensationActionDTORequest request);

    CompensationMiddleWare mapInfraestructureToModel(CompensationActionWithIdDTORequest request);

    CompensationActionDTOResponse mapModelToinfraestructure(CompensationMiddleWare model);

    List<CompensationActionDTOResponse> mapModelToinfraestructure(List<CompensationMiddleWare> model);

}
