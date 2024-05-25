package com.cruzroja.carbon_foot_print.Infrastucture.Output.Persistence.Entities;

import java.util.Date;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

/**
 * Clase de entidad que representa un usuario de empresa en la capa de persistencia.
 * Esta entidad mapea la tabla "companies" en la base de datos, que almacena información sobre los usuarios de empresa.
 * 
 * Contiene los siguientes atributos:
 * - companyNit: NIT de la empresa.
 * - companyName: Nombre de la empresa.
 * - companyPhone: Teléfono de la empresa.
 * - companyEmail: Correo electrónico de la empresa.
 * - address: Dirección de la empresa.
 * - registrationDate: Fecha de registro de la empresa.
 */
@Entity
@Table(name = "companies")
@Getter
@Setter
public class UserCompanyEntity extends UserEntity {
    
    /** NIT de la empresa. */
    private long companyNit;

    /** Nombre de la empresa. */
    @Column(nullable = false, unique = true, length = 45)
    private String companyName;

    /** Teléfono de la empresa. */
    @Column(nullable = false, length = 12)
    private String companyPhone;

    /** Correo electrónico de la empresa. */
    @Column(nullable = false, unique = true, length = 320)
    private String companyEmail;

    /** Dirección de la empresa. */
    @OneToOne(mappedBy = "objUserCompany", fetch = FetchType.EAGER, cascade = {CascadeType.ALL})
    private AddressEntity address;

    /** Fecha de registro de la empresa. */
    @Column(nullable = false)
    private Date registrationDate;

    /**
     * Constructor de la clase UserCompanyEntity.
     */
    public UserCompanyEntity(){

    }

    /**
     * Constructor de la clase UserCompanyEntity con todos los atributos.
     * 
     * @param documentNumber    Número de documento del usuario.
     * @param documentType      Tipo de documento del usuario.
     * @param names             Nombres del usuario.
     * @param lastNames         Apellidos del usuario.
     * @param personalPhone     Teléfono personal del usuario.
     * @param personalEmail     Correo electrónico personal del usuario.
     * @param username          Nombre de usuario del usuario.
     * @param password          Contraseña del usuario.
     * @param roles             Lista de roles asociados al usuario.
     * @param companyNit        NIT de la empresa.
     * @param companyName       Nombre de la empresa.
     * @param companyPhone      Teléfono de la empresa.
     * @param address           Dirección de la empresa.
     * @param registrationDate  Fecha de registro de la empresa.
     */
    public UserCompanyEntity(long documentNumber, String documentType, String names, String lastNames, String personalPhone,
                             String personalEmail, String username, String password, List<RoleEntity> roles, long companyNit,
                             String companyName, String companyPhone, AddressEntity address, Date registrationDate){
        super(documentNumber, documentType, names, lastNames, personalPhone, personalEmail, username, password, roles, true);
        this.companyNit = companyNit;
        this.companyName = companyName;
        this.companyPhone = companyPhone;
        this.address = address;
        this.registrationDate = registrationDate;
    }

}
