package com.cruzroja.carbon_foot_print.Infrastucture.Input.ControllerManegeCategory.DTOResponse;

import java.util.List;

import com.cruzroja.carbon_foot_print.Infrastucture.Input.ControllerManagePollutionType.DTOResponse.PollutionTypeDTOResponse;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CategoryWithRelationDTOResponse {
    private long categoryId;
    private String categoryName;
    private String categoryDescription;
    private String categoryScope;
    private List<PollutionTypeDTOResponse> pollutions;
}
