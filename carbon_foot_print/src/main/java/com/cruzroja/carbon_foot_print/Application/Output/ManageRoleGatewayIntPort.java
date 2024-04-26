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
     * @return Lista de roles {@code List<Role>}.
     */
    public List<Role> findAll();
    
    /**
     * Guarda un nuevo rol en el sistema.
     * 
     * @param role El rol a guardar.
     * @return El rol guardado {@code Role}.
     */
    public Role save(Role role);
    /**
     * Encuentra un rol por su ID.
     * 
     * @param idRole El ID del rol a encontrar.
     * @return El rol encontrado o {@code null} si no se encuentra {@code Role}.
     */
    public Role findByIdRole(long idRole);
     /**
     * Elimina un rol del sistema.
     * 
     * @param role El rol a eliminar.
     */
    public void deleteRole(Role role);
     /**
     * Recupera una lista de todos los permisos almacenados en el sistema.
     * 
     * @return Lista de permisos {@code List<Permission>}.
     */
    public List<Permission> findAllPermissions();
     /**
     * Verifica si un rol existe por su ID o tipo de rol.
     * 
     * @param idRole   El ID del rol a verificar.
     * @param typeRole El tipo de rol a verificar.
     * @return El ID del rol si existe por ID o tipo de rol, de lo contrario {@code 0} {@code long}.
     */


    public boolean existsByTypeRole(String typeRole);
    public boolean existsById(long idRole);

}