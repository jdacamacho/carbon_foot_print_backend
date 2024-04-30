package com.cruzroja.carbon_foot_print.Infrastucture.Input.ControllerManegeCategory.DTORequest;

import javax.swing.Spring;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CategoryDTORequest {
    @NotNull(message = "categoryName can't be null")
    @NotBlank(message = "categoryName can't be empty")
    @Size(min = 2, max = 50, message = "categoryName can't be shorter than 2 characters and longer than 50 characters")
    private String categoryName;
    @NotNull(message = "categoryDescription can't be null")
    @NotBlank(message = "categoryDescription can't be empty")
    private String categoryDescription;
    @NotNull(message = "categoryScope can't be null")
    @NotBlank(message = "categoryScope can't be empty")
    private String categoryScope;
}
