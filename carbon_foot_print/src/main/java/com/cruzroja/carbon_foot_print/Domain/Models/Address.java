package com.cruzroja.carbon_foot_print.Domain.Models;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * Clase que representa una dirección.
 */
@Data
@AllArgsConstructor
public class Address {
    
    /** NIT de la empresa asociada a esta dirección. */
    private long companyNit;
    
    /** Objeto UserCompany asociado a esta dirección. */
    private UserCompany objUserCompany;
    
    /** Calle de la dirección. */
    private String street;
    
    /** Número de la dirección. */
    private String number;
    
    /** Piso o apartamento de la dirección. */
    private String floorOrApartment;
    
    /** Barrio de la dirección. */
    private String neighborhood;
    
    /** Ciudad de la dirección. */
    private String city;
    
    /** País de la dirección. */
    private String country;

    /**
     * Constructor de la clase Address.
     */
    public Address(){
        
    }
}