package com.cruzroja.carbon_foot_print.Application.Output;

import java.util.List;

import com.cruzroja.carbon_foot_print.Domain.Models.Permission;
import com.cruzroja.carbon_foot_print.Domain.Models.Role;
  /**
 * Conexión con el servicio de persistencia
 */
public interface ManageRoleGatewayIntPort {
    /**
     * Recupera una lista de todos los roles almacenados en el sistema.
     * 
     * @return Lista de roles {List<Role>}.
     */
    public List<Role> findAll();
    
    /**
     * Guarda un nuevo rol en el sistema.
     * 
     * @param role El rol a guardar.
     * @return El rol guardado {Role}.
     */
    public Role save(Role role);

    /**
     * Encuentra un rol por su ID.
     * 
     * @param idRole El ID del rol a encontrar.
     * @return {boolean} [true] si el rol fue encontrado, [false] en caso contrario.
     */
    public Role findByIdRole(long idRole);

    /**
     * Recupera una lista de todos los permisos almacenados en el sistema.
     * 
     * @return Lista de permisos {List<Permission>}.
     */
    public List<Permission> findAllPermissions();

    /**
     * Verifica si un rol existe por su tipo de rol.
     * @param typeRole El tipo de rol a verificar.
     * @return {boolean} [true] si el rol fue encontrado, [false] en caso contrario.
     */
    public boolean existsByTypeRole(String typeRole);

     /**
     * Verifica si un rol existe por su id
     * @param idRole El id del rol a verificar.
     * @return {boolean} [true] si el rol fue encontrado, [false] en caso contrario.
     */
    public boolean existsById(long idRole);

}