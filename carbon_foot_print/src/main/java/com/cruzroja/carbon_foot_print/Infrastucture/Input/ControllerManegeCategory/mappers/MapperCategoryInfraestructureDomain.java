package com.cruzroja.carbon_foot_print.Infrastucture.Input.ControllerManegeCategory.mappers;

import java.util.List;

import org.mapstruct.Mapper;

import com.cruzroja.carbon_foot_print.Domain.Models.Category;
import com.cruzroja.carbon_foot_print.Infrastucture.Input.ControllerManegeCategory.DTORequest.CategoryDTORequest;
import com.cruzroja.carbon_foot_print.Infrastucture.Input.ControllerManegeCategory.DTORequest.CategoryWithIdDTORequest;
import com.cruzroja.carbon_foot_print.Infrastucture.Input.ControllerManegeCategory.DTOResponse.CategoryDTOResponse;

@Mapper(componentModel = "spring")
public interface MapperCategoryInfraestructureDomain {
    Category mapRequestModel(CategoryDTORequest request);

    Category mapRequestModel(CategoryWithIdDTORequest request);

    CategoryDTOResponse mapModelToResponse(Category model);

    List<CategoryDTOResponse> mapModelsToResponse(List<Category> cotegories);
}
