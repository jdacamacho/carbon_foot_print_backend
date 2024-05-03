package com.cruzroja.carbon_foot_print.Domain.Models;

import java.util.Date;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

/**
 * Clase que representa un usuario de empresa en el sistema.
 */
@Getter
@Setter
public class UserCompany extends User{
    
    /** NIT de la empresa. */
    private long companyNit;
    
    /** Nombre de la empresa. */
    private String companyName;
    
    /** Teléfono de la empresa. */
    private String companyPhone;
    
    /** Correo electrónico de la empresa. */
    private String companyEmail;
    
    /** Dirección de la empresa. */
    private Address address;
    
    /** Fecha de registro de la empresa. */
    private Date registrationDate;

    /**
     * Constructor de la clase UserCompany.
     */
    public UserCompany(){

    }

    /**
     * Constructor de la clase UserCompany con todos los atributos.
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
     * @param companyEmail      Correo electrónico de la empresa.
     * @param address           Dirección de la empresa.
     * @param registrationDate  Fecha de registro de la empresa.
     */
    public UserCompany(long documentNumber, String documentType, String names, String lastNames, String personalPhone,
                       String personalEmail, String username, String password, List<Role> roles, long companyNit,
                       String companyName, String companyPhone, String companyEmail, Address address, Date registrationDate){
        super(documentNumber, documentType, names, lastNames, personalPhone, personalEmail, username, password, roles, true);
        this.companyNit = companyNit;
        this.companyName = companyName;
        this.companyPhone = companyPhone;
        this.companyEmail = companyEmail;
        this.address = address;
        this.registrationDate = registrationDate;
    }

    /**
     * Actualiza los atributos del usuario de empresa.
     * 
     * @param company Usuario de empresa con los nuevos atributos.
     */
    public void update(UserCompany company) {
        super.update(company);
        this.companyNit = company.getCompanyNit();
        this.companyName = company.getCompanyName();
        this.companyPhone = company.getCompanyPhone();
        this.companyEmail = company.getCompanyEmail();
        this.address = company.getAddress();
    }

    /**
     * Establece la fecha de registro y la relación entre la dirección y el usuario de empresa.
     */
    public void setInformation(){
        this.setRegistrationDate(new Date());
        this.getAddress().setObjUserCompany(this);
        this.getAddress().setCompanyNit(companyNit);
    } 

    /**
     * Verifica si el NIT de la empresa coincide con el proporcionado.
     * 
     * @param companyNit NIT de la empresa a verificar.
     * @return true si el NIT coincide, false de lo contrario.
     */
    public boolean verifyNit(long companyNit){
        return this.companyNit == companyNit;
    }

    /**
     * Verifica si el nombre de la empresa coincide con el proporcionado.
     * 
     * @param companyName Nombre de la empresa a verificar.
     * @return true si el nombre de la empresa coincide, false de lo contrario.
     */
    public boolean verifyCompanyName(String companyName){
        return this.companyName.equals(companyName);
    }

    /**
     * Verifica si el correo electrónico de la empresa coincide con el proporcionado.
     * 
     * @param companyEmail Correo electrónico de la empresa a verificar.
     * @return true si el correo electrónico coincide, false de lo contrario.
     */
    public boolean verifyCompanyEmail(String companyEmail){
        return this.companyEmail.equals(companyEmail);
    }
}
