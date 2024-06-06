package com.cruzroja.carbon_foot_print.Infrastucture.Input.ControllerManageCompanyPlan.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.cruzroja.carbon_foot_print.Domain.Models.CompanyPlan;
import com.cruzroja.carbon_foot_print.Infrastucture.Input.ControllerManageCompanyPlan.DTOResponse.CompanyPlanDTOResponse;

@Mapper(componentModel = "spring")
public interface MapperCompanyPlanInfraestructureDomain {
    @Mapping(source = "model.plan.volunteer.documentNumber", target = "plan.volunteerId")
    CompanyPlanDTOResponse mapDomainToInfraestructure(CompanyPlan model);
}
