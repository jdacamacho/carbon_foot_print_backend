package com.cruzroja.carbon_foot_print.Application.Output;

import com.cruzroja.carbon_foot_print.Domain.Models.Role;
import com.cruzroja.carbon_foot_print.Domain.Models.UserVolunteer;
import java.util.List;

/**
 * Conexión con el servicio de persistencia
 */
public interface ManegeUserVolunteerGatewayIntPort {
    /**
     * Listar usuarios almacenados en el servicio de persistencia.
     * 
     * @return {List<UserVolunteer>} Lista de usuarios voluntarios.
     */
    public List<UserVolunteer> findAll();

    /**
     * Guarda un usuario en el servicio de persistencia.
     * 
     * @param userVolunteer {UserVolunteer} Información a guardar en el servicio de
     *                      persistencia.
     * @return {UserVolunteer} Usuario guardado en el servicio de persistencia.
     */
    public UserVolunteer save(UserVolunteer userVolunteer);

    /**
     * Recupera un usuario por el número de documento
     * 
     * @param numberDocument {long} número de documento del usuario.
     * @return {UserVolunteer} usuario recuperado del servicio de persistencia.
     */
    public UserVolunteer findUserVolunteerByNumberDocument(long numberDocument);

    /**
     * Recupera los usuarios voluntarios a partir de la posición que tienen
     * asignada.
     * 
     * @param position {String} posición del usuario.
     * @return {List<UserVolunteer>} Lista de usuarios encontrados en el servicio de
     *         persistecia.
     */
    public List<UserVolunteer> findUserVolunteerByPosition(String position);

    /**
     * Recupera los roles que están guardados en el servicio de persistencia.
     * 
     * @return {List<Role>} Lista de roles recuperada.
     */
    public List<Role> findRoles();

    /**
     * Determina si existe un usuario por el número de documento.
     * 
     * @param id {long} número de documento del usuario.
     * @return {boolean} [True] si el usuario fue encontrado [False] en caso
     *         contrario.
     */
    public boolean existById(long id);

    /**
     * Determina si existe un usuario a partir del nombre de usuario.
     * 
     * @param username {Strig} nombre de usuario.
     * @return {boolean} [True] si el usuario fue encontrado [False] en caso
     *         contrario.
     */
    public boolean existsByUsername(String username);

    /**
     * Determina si existe un usuario a partir del correo personal.
     * 
     * @param personalEmail {String} correo personal.
     * @return {boolean} [True] si el usuario fue encontrado [False] en caso
     *         contrario.
     */
    public boolean existsByPersonalEmail(String personalEmail);

}
