package com.cruzroja.carbon_foot_print.Infrastucture.Output.Persistence.Entities;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * Clase de entidad que representa un rol en la capa de persistencia.
 * Esta entidad mapea la tabla "roles" en la base de datos, que almacena información sobre los roles del sistema.
 * 
 * Contiene los siguientes atributos:
 * - idRole: Identificador único del rol.
 * - typeRole: Tipo de rol.
 * - state: Estado del rol.
 * - permissions: Lista de permisos asociados al rol.
 */
@Entity
@Table(name = "roles")
@Data
@AllArgsConstructor
public class RoleEntity {
    
    /** Identificador único del rol. */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idRole;

    /** Tipo de rol. */
    @Column(nullable = false, unique = true, length = 45)
    private String typeRole;

    /** Estado del rol. */
    @Column(nullable = false)
    private boolean state;

    /** Lista de permisos asociados al rol. */
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "role_permissions",
        joinColumns = @JoinColumn(name = "idRole"),
        inverseJoinColumns = @JoinColumn(name = "idPermission"))
    private List<PermissionEntity> permissions;

    /**
     * Constructor de la clase RoleEntity.
     * Este constructor inicializa la lista de permisos.
     */
    public RoleEntity(){
        this.permissions = new ArrayList<>();
    }
}
