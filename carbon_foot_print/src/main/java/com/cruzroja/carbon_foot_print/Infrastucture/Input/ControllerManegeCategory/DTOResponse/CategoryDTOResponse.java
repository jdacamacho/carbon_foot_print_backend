package com.cruzroja.carbon_foot_print.Infrastucture.Input.ControllerManegeCategory.DTOResponse;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CategoryDTOResponse {
    private long categoryId;
    private String categoryName;
    private String categoryDescription;
    private String categoryScope;
    private boolean categoryState;
}
