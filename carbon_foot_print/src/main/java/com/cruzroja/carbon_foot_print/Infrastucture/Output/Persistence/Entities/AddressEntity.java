package com.cruzroja.carbon_foot_print.Infrastucture.Output.Persistence.Entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;

@Entity
@Table(name = "addresses")
@Data
@AllArgsConstructor
public class AddressEntity {

    @Id
    @Column(name = "company_nit" , nullable = false , unique = true)
    private long companyNit;

    @OneToOne
    @MapsId
    @JoinColumn(name = "companyNit")
    private UserCompanyEntity objUserCompany;

    @Column(nullable = true)
    private String street;

    @Column(nullable = true)
    private String number;

    @Column(name = "floor/apartment",nullable = true)
    private String floorOrApartment;

    @Column(nullable = true)
    private String city;

    @Column(nullable = true)
    private String country;

    public AddressEntity(){

    }

}