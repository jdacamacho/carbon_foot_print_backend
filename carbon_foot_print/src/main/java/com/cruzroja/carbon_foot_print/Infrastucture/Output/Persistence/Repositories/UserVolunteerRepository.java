package com.cruzroja.carbon_foot_print.Infrastucture.Output.Persistence.Repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.cruzroja.carbon_foot_print.Infrastucture.Output.Persistence.Entities.RoleEntity;
import com.cruzroja.carbon_foot_print.Infrastucture.Output.Persistence.Entities.UserVolunteerEntity;

import java.util.List;

/**
 * Repositorio para la gestión de voluntarios en la capa de persistencia.
 * 
 * Proporciona métodos para interactuar con los voluntarios almacenados en la base de datos.
 */
public interface UserVolunteerRepository extends CrudRepository<UserVolunteerEntity, Long> {

    /**
     * Busca voluntarios por su posición.
     * 
     * @param position La posición del voluntario a buscar.
     * @return Una lista de voluntarios que tienen la posición especificada.
     */
    List<UserVolunteerEntity> findByPosition(String position);

    /**
     * Obtiene una lista de todos los roles disponibles.
     * 
     * @return Una lista de todos los roles en la base de datos.
     */
    @Query("from RoleEntity")
    List<RoleEntity> findAllRoles();

    /**
     * Determina si existe un usuario registrado con el correo electrónico personal proporcionado.
     * 
     * @param personalEmail El correo electrónico personal a verificar.
     * @return true si el usuario existe, false en caso contrario.
     */
    boolean existsByPersonalEmail(String personalEmail);

    /**
     * Determina si existe un usuario registrado con el nombre de usuario proporcionado.
     * 
     * @param username El nombre de usuario a verificar.
     * @return true si el usuario existe, false en caso contrario.
     */
    boolean existsByUsername(String username);
}
