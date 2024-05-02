package com.cruzroja.carbon_foot_print.Application.Input;

import java.util.List;

import com.cruzroja.carbon_foot_print.Domain.Models.UserCompany;

/**
 * Interfaz que define las operaciones para la gestión de usuarios de empresas en el sistema.
 */
public interface ManageUserCompanyCUIntPort {
    
    /**
     * Obtiene una lista de todos los usuarios de empresas registrados en el sistema.
     * 
     * @return Lista de usuarios de empresas si la operación se realiza con éxito, o un objeto Error si ocurre un fallo en las reglas de negocio.
    */
    public List<UserCompany> listUserCompany();

    /**
     * Guarda un usuario de empresa en el sistema.
     * 
     * @param userCompany Información del usuario de empresa a ser guardado.
     * @return Información del usuario de empresa guardado si la operación se realiza con éxito, o un objeto Error si ocurre un fallo en las reglas de negocio.
    */
    public UserCompany saveUserCompany(UserCompany userCompany);

    /**
     * Actualiza la información de un usuario de empresa en el sistema.
     * 
     * @param userCompany Nueva información del usuario de empresa.
     * @return Información actualizada del usuario de empresa si la operación se realiza con éxito, o un objeto Error si ocurre un fallo en las reglas de negocio.
    */
    public UserCompany updateUserCompany(UserCompany userCompany);

    /**
     * Obtiene un usuario de empresa por su número de documento.
     * 
     * @param numberDocument Número de documento del usuario de empresa.
     * @return Usuario de empresa recuperado si la operación se realiza con éxito, o un objeto Error si ocurre un fallo en las reglas de negocio.
    */
    public UserCompany getUserCompanyByNumberDocument(long numberDocument);

    /**
     * Obtiene un usuario de empresa por su NIT.
     * 
     * @param nitCompany NIT de la empresa.
     * @return Usuario de empresa recuperado por su NIT si la operación se realiza con éxito, o un objeto Error si ocurre un fallo en las reglas de negocio.
     */
    public UserCompany getUserCompanyByNit(long nitCompany);
}
