package com.cruzroja.carbon_foot_print.Infrastucture.Input.ControllerManageUserCompany.mappers;

import java.util.List;

import org.mapstruct.Mapper;

import com.cruzroja.carbon_foot_print.Domain.Models.UserCompany;
import com.cruzroja.carbon_foot_print.Infrastucture.Input.ControllerManageUserCompany.DTORequest.UserCompanyDTORequest;
import com.cruzroja.carbon_foot_print.Infrastucture.Input.ControllerManageUserCompany.DTOResponse.UserCompanyDTOResponse;

@Mapper(componentModel = "spring")
public interface MapperUserCompanyInfrastuctureDomain {
    UserCompany mapRequestToModel(UserCompanyDTORequest request);
    UserCompanyDTOResponse mapModelToResponse(UserCompany model);
    List<UserCompanyDTOResponse> mapModelsToResponse(List<UserCompany> companies);

}
