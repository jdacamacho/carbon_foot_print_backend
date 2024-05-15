package com.cruzroja.carbon_foot_print.Infrastucture.Input.ControllerManegeCategory.DTORequest;

import java.util.ArrayList;
import java.util.List;

import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CategoryByIds {
    @NotEmpty(message = "the list of ids is required to search, this can't be null")
    private List<Long> ids;

    public CategoryByIds() {
        this.ids = new ArrayList<Long>();
    }
}
