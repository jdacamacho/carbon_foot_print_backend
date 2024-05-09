package com.cruzroja.carbon_foot_print.Infrastucture.Input.ControllerManagePollutionType.mappers;

import com.cruzroja.carbon_foot_print.Domain.Models.PollutionType;
import com.cruzroja.carbon_foot_print.Infrastucture.Input.ControllerManagePollutionType.DTOResponse.PollutionTypeDTOResponse;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface MapperPollutionTypeInfraestructureDomain {


    PollutionTypeDTOResponse toPollutionTypeDTOResponse(PollutionType pollutionType);

    List<PollutionTypeDTOResponse> toPollutionTypeDTOResponseList(List<PollutionType> pollutionTypes);
}
