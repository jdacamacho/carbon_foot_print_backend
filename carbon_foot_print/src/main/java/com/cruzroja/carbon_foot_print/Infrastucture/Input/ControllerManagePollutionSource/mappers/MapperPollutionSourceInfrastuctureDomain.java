package com.cruzroja.carbon_foot_print.Infrastucture.Input.ControllerManagePollutionSource.mappers;

import org.mapstruct.Mapper;

import com.cruzroja.carbon_foot_print.Domain.Models.PollutionSource;
import com.cruzroja.carbon_foot_print.Infrastucture.Input.ControllerManagePollutionSource.DTOResponse.PollutionSourceDTOResponse;

import java.util.List;

@Mapper(componentModel = "spring")
public interface MapperPollutionSourceInfrastuctureDomain {
    List<PollutionSourceDTOResponse> mapModelToResponse(List<PollutionSource> models);
    PollutionSourceDTOResponse mapModelToResponse(PollutionSource model);
}
