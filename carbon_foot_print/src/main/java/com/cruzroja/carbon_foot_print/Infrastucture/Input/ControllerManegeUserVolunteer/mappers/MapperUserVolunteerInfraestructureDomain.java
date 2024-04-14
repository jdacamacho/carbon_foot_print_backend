package com.cruzroja.carbon_foot_print.Infrastucture.Input.ControllerManegeUserVolunteer.mappers;

import java.util.List;

import org.mapstruct.Mapper;

import com.cruzroja.carbon_foot_print.Domain.Models.UserVolunteer;
import com.cruzroja.carbon_foot_print.Infrastucture.Input.ControllerManegeUserVolunteer.DTORequest.UserVolunteerDTORequest;
import com.cruzroja.carbon_foot_print.Infrastucture.Input.ControllerManegeUserVolunteer.DTOResponse.UserVolunteerDTOResponse;

@Mapper(componentModel = "spring")
public interface MapperUserVolunteerInfraestructureDomain {
    UserVolunteer mapRequestModel(UserVolunteerDTORequest request);

    UserVolunteerDTOResponse mapModelToResponse(UserVolunteer model);

    List<UserVolunteerDTOResponse> mapModelsToResponse(List<UserVolunteer> volunteers);
}
