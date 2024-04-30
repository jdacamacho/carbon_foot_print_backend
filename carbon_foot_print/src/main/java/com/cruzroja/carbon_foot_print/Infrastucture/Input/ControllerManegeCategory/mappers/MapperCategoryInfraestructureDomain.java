package com.cruzroja.carbon_foot_print.Infrastucture.Input.ControllerManegeCategory.mappers;

import org.mapstruct.Mapper;

import com.cruzroja.carbon_foot_print.Domain.Models.Category;
import com.cruzroja.carbon_foot_print.Infrastucture.Input.ControllerManegeCategory.DTORequest.CategoryDTORequest;
import com.cruzroja.carbon_foot_print.Infrastucture.Input.ControllerManegeCategory.DTORequest.CategoryWithIdDTORequest;

@Mapper(componentModel = "spring")
public interface MapperCategoryInfraestructureDomain {
    Category mapRequestModel(CategoryDTORequest request);

    Category mapRequestModel(CategoryWithIdDTORequest request);
}
