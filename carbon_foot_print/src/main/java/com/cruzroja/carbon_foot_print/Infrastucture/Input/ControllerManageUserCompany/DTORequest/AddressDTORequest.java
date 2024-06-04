package com.cruzroja.carbon_foot_print.Infrastucture.Input.ControllerManageUserCompany.DTORequest;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AddressDTORequest {
    @NotNull(message = "street can't be null")
    @NotBlank(message = "street can't be empty")
    @Size(min = 1, max = 45, message = "street must be between 1 and 45 characters")
    private String street;

    @NotNull(message = "number can't be null")
    @NotBlank(message = "number can't be empty")
    @Size(min = 1, max = 45, message = "number must be between 1 and 45 characters")
    private String number;

    @NotNull(message = "floor/Apartment can't be null")
    @NotBlank(message = "floor/Apartment can't be empty")
    @Size(min = 1, max = 45, message = "floorOrApartmet must be between 1 and 45 characters")
    private String floorOrApartment;

    @NotNull(message = "neighborhood can't be null")
    @NotBlank(message = "neighborhood can't be empty")
    @Size(min = 1, max = 45, message = "neighborhood must be between 1 and 45 characters")
    private String neighborhood;

    @NotNull(message = "city can't be null")
    @NotBlank(message = "city can't be empty")
    @Size(min = 1, max = 45, message = "city must be between 1 and 45 characters")
    private String city;

    @NotNull(message = "country can't be null")
    @NotBlank(message = "country can't be empty")
    @Size(min = 1, max = 45, message = "country must be between 1 and 45 characters")
    private String country;

    public AddressDTORequest(){

    }
}
