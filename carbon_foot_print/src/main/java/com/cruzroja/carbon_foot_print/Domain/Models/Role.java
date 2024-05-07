package com.cruzroja.carbon_foot_print.Domain.Models;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * Clase que representa un rol en el sistema.
 * Los roles definen conjuntos de permisos que determinan las acciones que un usuario puede realizar en el sistema.
 */
@Data
@AllArgsConstructor
public class Role {
    
    /** Identificador único del rol. */
    private long idRole;
    
    /** Tipo de rol. */
    private String typeRole;
    
    /** Estado del rol. */
    private boolean state;
    
    /** Lista de permisos asociados al rol. */
    private List<Permission> permissions;

    /**
     * Constructor de la clase Role. Inicializa la lista de permisos.
     * Crea un nuevo rol con una lista de permisos vacía.
     */
    public Role(){
        this.permissions = new ArrayList<>();
    }

    /**
     * Actualiza los atributos del rol.
     * 
     * @param typeRole     Nuevo tipo de rol.
     * @param state        Nuevo estado del rol.
     * @param permissions  Nueva lista de permisos asociados al rol.
     */
    public void update(String typeRole, boolean state ,List<Permission> permissions){
        this.typeRole = typeRole;
        this.permissions = permissions;
        this.state = state;
    }

    /**
     * Verifica si el rol tiene los permisos válidos.
     * 
     * @param validPermissions Lista de permisos válidos.
     * @return true si el rol tiene todos los permisos válidos, false de lo contrario.
     */
    public boolean isValidPermission(List<Permission> validPermissions){
        List<Permission> permissions = this.getPermissions();
        int wasFound = 0;
        for (Permission permission : permissions) {
            for (Permission validPermission : validPermissions) {
                if(permission.equals(validPermission)) wasFound ++;
            }
        }
        return permissions.size() == wasFound;
    } 

    /**
     * Verifica si el rol tiene permisos duplicados.
     * 
     * @return true si el rol tiene permisos duplicados, false de lo contrario.
     */
    public boolean hasDuplicatePermissions(){
        Set<Permission> permissionSet = new HashSet<>(this.getPermissions());
        return permissionSet.size() < this.getPermissions().size();
    }

    /**
     * Verifica si el tipo de rol coincide con el proporcionado.
     * 
     * @param typeRole Tipo de rol a verificar.
     * @return true si el tipo de rol coincide, false de lo contrario
     */
    public boolean verifyTypeRole(String typeRole){
        return this.typeRole.equals(typeRole);
    }
}
