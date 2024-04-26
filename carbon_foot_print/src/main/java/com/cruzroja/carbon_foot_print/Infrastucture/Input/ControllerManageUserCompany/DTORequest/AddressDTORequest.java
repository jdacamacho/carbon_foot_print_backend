package com.cruzroja.carbon_foot_print.Infrastucture.Input.ControllerManageUserCompany.DTORequest;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AddressDTORequest {
    @NotNull(message = "street can't be null")
    @NotBlank(message = "street can't be empty")
    private String street;

    @NotNull(message = "number can't be null")
    @NotBlank(message = "number can't be empty")
    private String number;

    @NotNull(message = "floor/Apartment can't be null")
    @NotBlank(message = "floor/Apartment can't be empty")
    private String floorOrApartment;

    @NotNull(message = "neighborhood can't be null")
    @NotBlank(message = "neighborhood can't be empty")
    private String neighborhood;

    @NotNull(message = "city can't be null")
    @NotBlank(message = "city can't be empty")
    private String city;

    @NotNull(message = "country can't be null")
    @NotBlank(message = "country can't be empty")
    private String country;

    public AddressDTORequest(){

    }
}
