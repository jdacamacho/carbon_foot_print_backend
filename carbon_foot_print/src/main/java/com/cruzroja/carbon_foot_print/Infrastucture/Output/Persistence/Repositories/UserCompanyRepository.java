package com.cruzroja.carbon_foot_print.Infrastucture.Output.Persistence.Repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.cruzroja.carbon_foot_print.Infrastucture.Output.Persistence.Entities.RoleEntity;
import com.cruzroja.carbon_foot_print.Infrastucture.Output.Persistence.Entities.UserCompanyEntity;

/**
 * Repositorio para la gestión de empresas en la capa de persistencia.
 * 
 * Proporciona métodos para interactuar con las empresas almacenadas en la base de datos.
 */
public interface UserCompanyRepository extends CrudRepository<UserCompanyEntity,Long>{

    /**
     * Obtiene una lista de todos los roles disponibles.
     * 
     * @return La lista de roles disponibles.
     */
    @Query("from RoleEntity")
    List<RoleEntity> findAllRoles();

    /**
     * Busca una empresa por su NIT.
     * 
     * @param companyNit El NIT de la empresa.
     * @return La entidad de empresa encontrada, o null en caso contrario.
     */
    UserCompanyEntity findByCompanyNit(long companyNit);

    /**
     * Verifica si existe una empresa por su NIT.
     * 
     * @param companyNit NIT de la empresa.
     * @return true si existe la empresa, false en caso contrario.
     */
    boolean existsByCompanyNit(long companyNit);

    /**
     * Verifica si existe una empresa por su correo electrónico.
     * 
     * @param companyEmail Correo electrónico de la empresa.
     * @return true si existe la empresa, false en caso contrario.
     */
    boolean existsByCompanyEmail(String companyEmail);

    /**
     * Verifica si existe una empresa por su nombre.
     * 
     * @param companyName Nombre de la empresa.
     * @return true si existe la empresa, false en caso contrario.
     */
    boolean existsByCompanyName(String companyName);
    
    /**
     * Verifica si existe una empresa con el NIT, correo electrónico o nombre.
     * 
     * @param nit NIT de la empresa.
     * @param companyEmail Correo electrónico de la empresa.
     * @param companyName Nombre de la empresa.
     * @return true si existe la empresa, false en caso contrario.
     */
    boolean existsByCompanyNitOrCompanyEmailOrCompanyName(long nit, String companyEmail, String companyName);
}
