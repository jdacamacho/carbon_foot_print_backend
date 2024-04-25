package com.cruzroja.carbon_foot_print.Application.Output;

import java.util.List;

import com.cruzroja.carbon_foot_print.Domain.Models.Role;
import com.cruzroja.carbon_foot_print.Domain.Models.UserCompany;

/**
 * Conexión con el módulo de persistencia.
 */
public interface ManageUserCompanyGatewayIntPort {

     /**
      * Recupera una lista de todas las empresas almacenadas en el sistema.
      * 
      * @return Lista de empresas {List<UserCompany>}.
     */
    public List<UserCompany> findAll();

     /**
      * Guarda una empresa en el sistema de persistencia.
      * 
      * @param userCompany La empresa a guardar.
      * @return {userCompany} La empresa guardada.
     */
    public UserCompany save(UserCompany userCompany);

     /**
      * Busca una empresa por su número de documento.
      * 
      * @param numberDocument El número de documento de la empresa.
      * @return La empresa encontrada, o {@code null} si no se encuentra ninguna empresa
      *  con el número de documento especificado.
     */
    public UserCompany findUserCompanyByNumberDocument(long numberDocument);

     /**
      * Verifica si existe una empresa con el número de documento especificado.
      * 
      * @param numberDocument El número de documento de la empresa.
      * @return {boolean} [true] si existe una empresa con el número de documento 
        especificado, [false] de lo contrario.
     */
    public boolean existsUserCompanyByNumberDocument(long numberDocument);

     /**
      * Verifica si existe una empresa con el NIT, correo electrónico o nombre de empresa especificados.
      * 
      * @param nitCompany     El NIT de la empresa.
      * @param companyEmail   El correo electrónico de la empresa.
      * @param companyName    El nombre de la empresa.
      * @return {boolean} [true] si existe una empresa con el NIT, correo electrónico o nombre de empresa
        especificados, [false] de lo contrario.
     */
    public boolean existsByCompanyNitOrCompanyEmailOrCompanyName(long nitCompany, String companyEmail,
        String companyName);

     /**
      * Verifica si existe una empresa con el NIT especificado.
      * 
      * @param nitCompany El NIT de la empresa.
      * @return {boolean} [true] si existe una empresa con el NIT especificado,
        [false] de lo contrario.
     */
    public boolean existsCompanyByNit(long nitCompany);
  
     /**
      * Busca una empresa por su NIT.
      * 
      * @param nitCompany El NIT de la empresa.
      * @return La empresa encontrada, o {null} si no se encuentra ninguna empresa.
     */
    public UserCompany findByCompanyNit(long nitCompany);

    public boolean existByUsername(String username);
    public boolean existsByPersonalEmail(String personalEmail);
    public boolean existsByNit(long nit);
    public boolean existsByCompanyEmail(String companyEmail);
    public boolean existsByCompanyName(String companyEmail);


    public List<Role> findAllRoles();
}
