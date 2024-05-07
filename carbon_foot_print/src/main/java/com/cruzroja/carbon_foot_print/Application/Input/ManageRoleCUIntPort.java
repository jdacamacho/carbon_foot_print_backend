package com.cruzroja.carbon_foot_print.Application.Input;

import java.util.List;

import com.cruzroja.carbon_foot_print.Domain.Models.Permission;
import com.cruzroja.carbon_foot_print.Domain.Models.Role;

/**
 * Interfaz que define las operaciones para la gestión de roles en el sistema.
 */
public interface ManageRoleCUIntPort {

    /**
     * Obtiene una lista de todos los roles del sistema.
     *
     * @return Lista de roles si la operación se realiza con éxito, o un objeto Error si ocurre un fallo.
     */
    public List<Role> listRoles();

    /**
     * Guarda un nuevo rol en el sistema.
     *
     * @param role El rol a guardar.
     * @return La información del rol guardado si la operación se realiza con éxito, o un objeto Error si ocurre un fallo.
     */
    public Role saveRole(Role role);

    /**
     * Obtiene un rol específico por su identificador.
     *
     * @param roleId El identificador del rol.
     * @return El rol encontrado, o un objeto Error si ocurre un fallo.
     */
    public Role getRole(long idRole);

    /**
     * Actualiza la información de un rol en el sistema.
     *
     * @param role El rol con la información actualizada.
     * @return El rol actualizado si la operación se realiza con éxito, o un objeto Error si ocurre un fallo.
     */
    public Role updateRole(Role role);

    /**
     * Obtiene una lista de todos los permisos disponibles en el sistema.
     *
     * @return Lista de permisos si la operación se realiza con éxito, o un objeto Error si ocurre un fallo.
     */
    public List<Permission> listPermissions();
}
