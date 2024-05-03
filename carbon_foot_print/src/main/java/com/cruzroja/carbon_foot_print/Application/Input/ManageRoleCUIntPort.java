package com.cruzroja.carbon_foot_print.Application.Input;

import java.util.List;

import com.cruzroja.carbon_foot_print.Domain.Models.Permission;
import com.cruzroja.carbon_foot_print.Domain.Models.Role;

public interface ManageRoleCUIntPort {

    /**
     * Reglas de negocio para listar todos los roles del sistema.
     *
     * @return Lista de roles {List<Role>} o {Error} en caso de fallo.
     */
    public List<Role> listRoles();

    /**
     *  Reglas de negocio para guardar un nuevo rol.
     * @param role {Role} que representa el rol a guardar.
     * @return {Role} información del rol guardado o {Error} en caso de fallo.
     */
    public Role saveRole(Role role);

    /**
     * Reglas de negocio para consultar un rol específico por su identificador.
     *
     * @param roleId Identificador del rol {long}
     * @return Rol encontrado {Role} o  {Error} en caso de fallo.
     */
    public Role getRole(long idRole);

    /**
     * Reglas de negocio para actualizar la información de un rol.
     *
     * @param role  {Role} que representa el rol actualizado.
     * @return Rol actualizado {Role} o  {Error} en caso de fallo.
     */
    public Role updateRole(Role role);

    /**
     * Reglas de negocio para obtener una lista de todos los permisos disponibles.
     *
     * @return Lista de permisos {List<Permission>} o un objeto {Error} en caso de fallo.
     */
    public List<Permission> listPermissions();
}
