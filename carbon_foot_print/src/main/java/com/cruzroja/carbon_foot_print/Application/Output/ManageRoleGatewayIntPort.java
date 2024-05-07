package com.cruzroja.carbon_foot_print.Application.Output;

import java.util.List;

import com.cruzroja.carbon_foot_print.Domain.Models.Permission;
import com.cruzroja.carbon_foot_print.Domain.Models.Role;

/**
 * Esta interfaz proporciona métodos para gestionar roles y permisos en el sistema.
 */
public interface ManageRoleGatewayIntPort {

    /**
     * Recupera una lista de todos los roles almacenados en el sistema.
     * 
     * @return Una lista de roles.
     */
    public List<Role> findAll();
    
    /**
     * Guarda un nuevo rol en el sistema.
     * 
     * @param role El rol a guardar.
     * @return El rol guardado.
     */
    public Role save(Role role);

    /**
     * Encuentra un rol por su ID.
     * 
     * @param idRole El ID del rol a encontrar.
     * @return El rol correspondiente al ID especificado, o null si no se encuentra.
     */
    public Role findByIdRole(long idRole);

    /**
     * Recupera una lista de todos los permisos almacenados en el sistema.
     * 
     * @return Una lista de permisos.
     */
    public List<Permission> findAllPermissions();

    /**
     * Verifica si un rol existe por su tipo de rol.
     * 
     * @param typeRole El tipo de rol a verificar.
     * @return [true] si el rol existe, [false] en caso contrario.
     */
    public boolean existsByTypeRole(String typeRole);

    /**
     * Verifica si un rol existe por su ID.
     * 
     * @param idRole El ID del rol a verificar.
     * @return [true] si el rol existe, [false] en caso contrario.
     */
    public boolean existsById(long idRole);

}
