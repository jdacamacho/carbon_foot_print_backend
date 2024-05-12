package com.cruzroja.carbon_foot_print.Infrastucture.Input.ControllerManagePollutionType.mappers;

import com.cruzroja.carbon_foot_print.Domain.Models.PollutionType;
import com.cruzroja.carbon_foot_print.Infrastucture.Input.ControllerManagePollutionType.DTORequest.PollutionTypeDTORequest;
import com.cruzroja.carbon_foot_print.Infrastucture.Input.ControllerManagePollutionType.DTORequest.PollutionTypeWithIdDTORequest;
import com.cruzroja.carbon_foot_print.Infrastucture.Input.ControllerManagePollutionType.DTOResponse.PollutionTypeDTOResponse;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface MapperPollutionTypeInfraestructureDomain {

    PollutionType requestToModel(PollutionTypeDTORequest request);

    PollutionType requestToModel(PollutionTypeWithIdDTORequest request);

    PollutionTypeDTOResponse toPollutionTypeDTOResponse(PollutionType pollutionType);

    List<PollutionTypeDTOResponse> toPollutionTypeDTOResponseList(List<PollutionType> pollutionTypes);
}
