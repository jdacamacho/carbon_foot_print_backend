package com.cruzroja.carbon_foot_print.Infrastucture.Input.ControllerManageCompanyPlan.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.cruzroja.carbon_foot_print.Domain.Models.CompanyPlan;
import com.cruzroja.carbon_foot_print.Domain.Models.CompensationPlan;
import com.cruzroja.carbon_foot_print.Infrastucture.Input.ControllerManageCompanyPlan.DTOResponse.CompanyPlanDTOResponse;
import com.cruzroja.carbon_foot_print.Infrastucture.Input.ControllerManageCompensationPlan.DTOResponse.CompensationPlanDTOResponse;

@Mapper(componentModel = "spring")
public interface MapperCompanyPlanInfraestructureDomain {
    @Mapping(source = "model.plan.volunteer.documentNumber", target = "plan.volunteerId")
    CompanyPlanDTOResponse mapDomainToInfraestructure(CompanyPlan model);

    @Mapping(source = "model.volunteer.documentNumber", target = "volunteerId")
    CompensationPlanDTOResponse mapDomainToInfraestructure(CompensationPlan model);

    List<CompensationPlanDTOResponse> mapDomainToInfraestructure(List<CompensationPlan> model);
}
