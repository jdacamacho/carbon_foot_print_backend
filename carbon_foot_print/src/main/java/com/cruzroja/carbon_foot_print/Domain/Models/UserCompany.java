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
    private String companyEmail;
    private Address address;
    private Date registrationDate;

    public UserCompany(){

    }

    public UserCompany(long documentNumber,String documentType,
                            String names, String lastNames,String personalPhone,
                            String personalEmail,String username,String password,
                            List<Role> roles,long companyNit,String companyName,
                            String companyPhone,String companyEmail,Address address, Date registrationDate){
        super(documentNumber,documentType,
                names,lastNames,personalPhone,
                personalEmail,username,password,
                roles,true);
        this.companyNit = companyNit;
        this.companyName = companyName;
        this.companyPhone = companyPhone;
        this.companyEmail = companyEmail;
        this.address = address;
        this.registrationDate = registrationDate;
    }

    public void update(UserCompany company) {
        super.update(company);
        this.companyNit = company.getCompanyNit();
        this.companyName = company.getCompanyName();
        this.companyPhone = company.getCompanyPhone();
        this.companyEmail = company.getCompanyEmail();
        this.address = company.getAddress();
    }

    public void setInformation(){
        this.setRegistrationDate(new Date());
        this.getAddress().setObjUserCompany(this);
        this.getAddress().setCompanyNit(companyNit);
    } 

    public boolean verifyNit(long companyNit){
        return this.companyNit == companyNit;
    }

    public boolean verifyCompanyName(String companyName){
        return this.companyName.equals(companyName);
    }

    public boolean verifyCompanyEmail(String companyEmail){
        return this.companyEmail.equals(companyEmail);
    }

}
