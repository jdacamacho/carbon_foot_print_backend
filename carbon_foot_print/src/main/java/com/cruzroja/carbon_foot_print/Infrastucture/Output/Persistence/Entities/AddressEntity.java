package com.cruzroja.carbon_foot_print.Infrastucture.Output.Persistence.Entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * Clase de entidad que representa una dirección en la capa de persistencia.
 */
@Entity
@Table(name = "addresses")
@Data
@AllArgsConstructor
public class AddressEntity {
    
    /** NIT de la empresa asociada a la dirección. */
    @Id
    private long companyNit;

    /** Entidad de usuario de empresa asociada a la dirección. */
    @OneToOne
    @JoinColumn(name = "documentNumber")
    private UserCompanyEntity objUserCompany;

    /** Calle de la dirección. */
    @Column(nullable = true)
    private String street;

    /** Número de la dirección. */
    @Column(nullable = true)
    private String number;

    /** Piso o apartamento de la dirección. */
    @Column(name = "floor/apartment", nullable = true)
    private String floorOrApartment;

    /** Barrio de la dirección. */
    @Column(nullable = true)
    private String neighborhood;

    /** Ciudad de la dirección. */
    @Column(nullable = true)
    private String city;

    /** País de la dirección. */
    @Column(nullable = true)
    private String country;

    /**
     * Constructor de la clase AddressEntity.
     */
    public AddressEntity(){

    }
}
