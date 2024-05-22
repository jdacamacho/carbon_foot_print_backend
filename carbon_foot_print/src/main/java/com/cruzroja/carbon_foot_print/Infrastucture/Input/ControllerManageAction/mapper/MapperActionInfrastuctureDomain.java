package com.cruzroja.carbon_foot_print.Infrastucture.Input.ControllerManageAction.mapper;

import java.util.List;

import org.mapstruct.Mapper;

import com.cruzroja.carbon_foot_print.Domain.Models.Action;
import com.cruzroja.carbon_foot_print.Infrastucture.Input.ControllerManageAction.DTORequest.ActionDTORequest;
import com.cruzroja.carbon_foot_print.Infrastucture.Input.ControllerManageAction.DTORequest.ActionWithIdDTORequest;
import com.cruzroja.carbon_foot_print.Infrastucture.Input.ControllerManageAction.DTOResponse.ActionDTOResponse;

@Mapper(componentModel = "spring")
public interface MapperActionInfrastuctureDomain {
    Action mapRequestToModel(ActionDTORequest request);
    Action mapRequestToModel(ActionWithIdDTORequest request);
    ActionDTOResponse mapModelToResponse(Action model);
    List<ActionDTOResponse> mapModelsToResponse(List<Action> models);
}

