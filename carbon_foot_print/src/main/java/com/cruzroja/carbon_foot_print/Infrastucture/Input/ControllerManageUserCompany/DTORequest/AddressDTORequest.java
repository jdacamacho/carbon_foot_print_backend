package com.cruzroja.carbon_foot_print.Infrastucture.Input.ControllerManageUserCompany.DTORequest;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AddressDTORequest {
    private String street;
    private String number;
    private String floorOrApartment;
    private String neighborhood;
    private String city;
    private String country;

    public AddressDTORequest(){

    }
}
