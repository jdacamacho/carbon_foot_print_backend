package com.cruzroja.carbon_foot_print.Infrastucture.Input.ControllerManageSource.mappers;

import java.util.List;

import org.mapstruct.Mapper;

import com.cruzroja.carbon_foot_print.Domain.Models.Source;
import com.cruzroja.carbon_foot_print.Infrastucture.Input.ControllerManageSource.DTORequest.SourceDTORequest;
import com.cruzroja.carbon_foot_print.Infrastucture.Input.ControllerManageSource.DTORequest.SourceWithIdDTORequest;
import com.cruzroja.carbon_foot_print.Infrastucture.Input.ControllerManageSource.DTOResponse.SourceDTOResponse;

@Mapper(componentModel = "spring")
public interface MapperSourceInfrastuctureDomain {
    Source mapRequestWithIdToModel(SourceWithIdDTORequest request);
    Source mapRequestToModel(SourceDTORequest request);
    SourceDTOResponse mapModelToTesponse(Source model);
    List<SourceDTOResponse> mapModelsToResponse(List<Source> sources);
}
