package com.cruzroja.carbon_foot_print.Infrastucture.Output.Persistence.Repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.cruzroja.carbon_foot_print.Infrastucture.Output.Persistence.Entities.UserEntity;

/**
 * Repositorio para la gestión de usuarios en la capa de persistencia.
 * 
 * Proporciona métodos para interactuar con los usuarios almacenados en la base de datos.
 */
public interface UserRepository  extends CrudRepository<UserEntity, Long>{
    
    /**
     * Cuenta el número de usuarios que coinciden con el número de documento, nombre de usuario o correo electrónico personal especificados.
     * 
     * @param numberDocument El número de documento a verificar.
     * @param username El nombre de usuario a verificar.
     * @param personalEmail El correo electrónico personal a verificar.
     * @return El número de usuarios que coinciden con los criterios de búsqueda.
     */
    @Query("SELECT COUNT(u) FROM UserEntity u WHERE u.documentNumber = :numberDocument OR u.username = :username OR u.personalEmail = :personalEmail")
    Long countByNumberDocumentOrUsernameOrPersonalEmail(@Param("numberDocument") long numberDocument,@Param("username") String username,@Param("personalEmail") String personalEmail);

    /**
     * Cuenta el número de usuarios que coinciden con el nombre de usuario especificado.
     * 
     * @param username El nombre de usuario a verificar.
     * @return El número de usuarios que coinciden con el nombre de usuario especificado.
     */
    @Query("SELECT COUNT(u) FROM UserEntity u WHERE u.username = :username")
    Long countByUsername(@Param("username") String username);

    /**
     * Verifica si existe un usuario con el nombre de usuario especificado.
     * 
     * @param username El nombre de usuario a verificar.
     * @return true si existe el usuario, false en caso contrario.
     */
    boolean existsByUsername(String username);

    /**
     * Verifica si existe un usuario con el correo electrónico personal especificado.
     * 
     * @param personalEmail El correo electrónico personal a verificar.
     * @return true si existe el usuario, false en caso contrario.
     */
    boolean existsByPersonalEmail(String personalEmail);

    /**
     * Busca un usuario por su nombre de usuario.
     * 
     * @param username El nombre de usuario a buscar.
     * @return El usuario encontrado, o un objeto Optional vacío si no se encuentra.
     */
    Optional<UserEntity> findByUsername(String username);

}
