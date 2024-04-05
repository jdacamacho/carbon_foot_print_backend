package com.cruzroja.carbon_foot_print.Infrastucture.Output.Persistence.Entities;

import java.util.Date;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "companies")
public class UserCompanyEntity extends UserEntity {
    
    @Column(name = "company_nit", nullable = false , unique = true)
    private long companyNit;

    @Column(name = "company_name", nullable = false , unique = true)
    private String companyName;

    @Column(name = "company_phone", nullable = true)
    private String companyPhone;

    @OneToOne(mappedBy = "objUserCompany", fetch = FetchType.LAZY)
    private AddressEntity address;

    @Column(name = "registration_date", nullable = false)
    private Date registrationDate;

    public UserCompanyEntity(){

    }

    public UserCompanyEntity(long documentNumber,String documentType,
                            String names, String lastNames,String personalPhone,
                            String personalEmail,String username,String password,
                            List<RoleEntity> roles,long companyNit,String companyName,
                            String companyPhone,AddressEntity address, Date registrationDate){
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
