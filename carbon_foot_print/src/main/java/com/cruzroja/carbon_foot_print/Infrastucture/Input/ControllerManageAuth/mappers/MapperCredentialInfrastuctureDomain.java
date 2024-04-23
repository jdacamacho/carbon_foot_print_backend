package com.cruzroja.carbon_foot_print.Infrastucture.Input.ControllerManageAuth.mappers;


import org.mapstruct.Mapper;

import com.cruzroja.carbon_foot_print.Domain.Models.Credential;
import com.cruzroja.carbon_foot_print.Infrastucture.Input.ControllerManageAuth.DTOResponse.CredentialDTOResponse;

@Mapper(componentModel = "spring")
public interface MapperCredentialInfrastuctureDomain {
    CredentialDTOResponse mapModelToResponse(Credential credential);
}