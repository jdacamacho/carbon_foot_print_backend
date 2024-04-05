package com.cruzroja.carbon_foot_print.Domain.Models;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Address {
    private long companyNit;
    private UserCompany objUserCompany;
    private String street;
    private String number;
    private String floorOrApartment;
    private String city;
    private String country;

    public Address(){
        
    }
}
