package com.cruzroja.carbon_foot_print.Infrastucture.Input.ControllerManageUserCompany.DTOResponse;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AddressDTOResponse {
    private long documentNumber;
    private UserCompanyDTOResponse objUserCompany;
    private String street;
    private String number;
    private String floorOrApartment;
    private String city;
    private String country;

    public AddressDTOResponse(){
        
    }
}
