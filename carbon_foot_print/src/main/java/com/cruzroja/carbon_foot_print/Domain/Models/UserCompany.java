package com.cruzroja.carbon_foot_print.Domain.Models;

import java.util.Date;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserCompany extends User{
    private long companyNit;
    private String companyName;
    private String companyPhone;
    private Address address;
    private Date registrationDate;

    public UserCompany(){

    }

    public UserCompany(long documentNumber,String documentType,
                            String names, String lastNames,String personalPhone,
                            String personalEmail,String username,String password,
                            List<Role> roles,long companyNit,String companyName,
                            String companyPhone,Address address, Date registrationDate){
        super(documentNumber,documentType,
                names,lastNames,personalPhone,
                personalEmail,username,password,
                roles,true);
        this.companyNit = companyNit;
        this.companyName = companyName;
        this.companyPhone = companyPhone;
        this.address = address;
        this.registrationDate = registrationDate;
    }
}
