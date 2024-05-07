package com.cruzroja.carbon_foot_print.Application.Output;

import com.cruzroja.carbon_foot_print.Domain.Models.Role;
import com.cruzroja.carbon_foot_print.Domain.Models.UserVolunteer;
import java.util.List;

/**
 * Interfaz para gestionar la conexión con el servicio de persistencia de usuarios voluntarios.
 */
public interface ManegeUserVolunteerGatewayIntPort {

    /**
     * Lista todos los usuarios voluntarios almacenados en el servicio de persistencia.
     * 
     * @return Lista de usuarios voluntarios.
     */
    public List<UserVolunteer> findAll();

    /**
     * Guarda un usuario voluntario en el servicio de persistencia.
     * 
     * @param userVolunteer Información del usuario voluntario a guardar.
     * @return Usuario voluntario guardado en el servicio de persistencia.
     */
    public UserVolunteer save(UserVolunteer userVolunteer);

    /**
     * Recupera un usuario voluntario por su número de documento.
     * 
     * @param numberDocument Número de documento del usuario voluntario.
     * @return Usuario voluntario recuperado del servicio de persistencia, o null si no se encuentra.
     */
    public UserVolunteer findUserVolunteerByNumberDocument(long numberDocument);

    /**
     * Recupera los usuarios voluntarios que tienen asignada una posición específica.
     * 
     * @param position Posición del usuario voluntario.
     * @return Lista de usuarios voluntarios encontrados en el servicio de persistencia, o null si no se encuentra ninguno.
     */
    public List<UserVolunteer> findUserVolunteerByPosition(String position);

    /**
     * Recupera los roles disponibles en el servicio de persistencia.
     * 
     * @return Lista de roles recuperados del servicio de persistencia.
     */
    public List<Role> findRoles();

    /**
     * Determina si existe un usuario voluntario con el número de documento especificado.
     * 
     * @param id Número de documento del usuario voluntario.
     * @return true si el usuario voluntario existe en el servicio de persistencia, false de lo contrario.
     */
    public boolean existsById(long id);

    /**
     * Determina si existe un usuario voluntario con el nombre de usuario especificado.
     * 
     * @param username Nombre de usuario del usuario voluntario.
     * @return true si el usuario voluntario existe en el servicio de persistencia, false de lo contrario.
     */
    public boolean existsByUsername(String username);

    /**
     * Determina si existe un usuario voluntario con el correo electrónico personal especificado.
     * 
     * @param personalEmail Correo electrónico personal del usuario voluntario.
     * @return true si el usuario voluntario existe en el servicio de persistencia, false de lo contrario.
     */
    public boolean existsByPersonalEmail(String personalEmail);
}
