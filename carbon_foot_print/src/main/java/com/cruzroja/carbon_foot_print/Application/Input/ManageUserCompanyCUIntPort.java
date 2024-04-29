package com.cruzroja.carbon_foot_print.Application.Input;

import java.util.List;

import com.cruzroja.carbon_foot_print.Domain.Models.UserCompany;

public interface ManageUserCompanyCUIntPort {
    
    /**
     * Reglas de negocio para listar todos los usuarios de empresas registrados.
     * 
     * @return {List<UserCompany>} lista de usuarios de empresas o {Error} en caso de fallo en las reglas de negocio.
    */
    public List<UserCompany> listUserCompany();

    /**
     * Reglas de negocio para guardar un usuario de empresa.
     * 
     * @param userCompany {UserCompany} Información del usuario de empresa a ser guardado.
     * @return {UserCompany} Información del usuario de empresa guardado o {Error} en caso de fallo en las reglas de negocio.
    */
    public UserCompany saveUserCompany(UserCompany userCompany);

    /**
     * Reglas de negocio para actualizar la información de un usuario de empresa.
     * 
     * @param userCompany {UserCompany} Nueva información del usuario de empresa.
     * @return {UserCompany} Información actualizada del usuario de empresa o {Error} en caso de fallo en las reglas de negocio.
    */
    public UserCompany updateUserCompany(UserCompany userCompany);

    /**
     * Reglas de negocio para obtener un usuario de empresa por su número de documento.
     * 
     * @param numberDocument {long} Número de documento del usuario de empresa.
     * @return {UserCompany} Usuario de empresa recuperado o {Error} en caso de fallo en las reglas de negocio.
    */
    public UserCompany getUserCompanyByNumberDocument(long numberDocument);

    /**
     * Reglas de negocio para obtener un usuario de empresa por su NIT.
     * 
     * @param nitCompany {long} NIT de la empresa.
     * @return {UserCompany} Usuario de empresa recuperado por su NIT o {Error} en caso de fallo en las reglas de negocio.
     */
    public UserCompany getUserCompanyByNit(long nitCompany);
}
