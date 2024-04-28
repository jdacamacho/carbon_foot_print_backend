package com.cruzroja.carbon_foot_print.Infrastucture.Output.Persistence.Repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.cruzroja.carbon_foot_print.Infrastucture.Output.Persistence.Entities.RoleEntity;
import com.cruzroja.carbon_foot_print.Infrastucture.Output.Persistence.Entities.UserCompanyEntity;

public interface UserCompanyRepository extends CrudRepository<UserCompanyEntity,Long>{

    @Query("from RoleEntity")
    List<RoleEntity> findAllRoles();

    /**
     * Busca una empresa por su NIT.
     * 
     * @param companyNit El NIT de la empresa. {long}
     * @return La entidad de empresa encontrada, o null en caso contrario 
     */
    UserCompanyEntity findByCompanyNit(long companyNit);

   /**
    * Verifica si existe una empresa por su NIT
    * @param companyNit Nit de la empresa {long}
    * @return {boolean} [true] si existe la empresa, [false] en caso contrario.
    */
    boolean existsByCompanyNit(long companyNit);

    /**
     * Verifica si existe una empresa por su Email
     * @param companyEmail Email de la empresa {String}
     * @return {boolean} [true] si existe la empresa, [false] en caso contrario.
     */
    boolean existsByCompanyEmail(String companyEmail);

    /**
     * Verifica si existe una empresa por su nombre
     * @param companyName nombre de la empresa {String}
     * @return {boolean} [true] si existe la empresa, [false] en caso contrario.
     */
    boolean existsByCompanyName(String companyName);
    
    /**
     * Verifica si existe una empresa con el NIT, correo electrónico o nombre.
     * @param nit
     * @param companyEmail
     * @param companyName
     * @return {boolean} [true] si existe la empresa, [false] en caso contrario.
     */
    boolean existsByCompanyNitOrCompanyEmailOrCompanyName(long nit, String companyEmail, String companyName);

}