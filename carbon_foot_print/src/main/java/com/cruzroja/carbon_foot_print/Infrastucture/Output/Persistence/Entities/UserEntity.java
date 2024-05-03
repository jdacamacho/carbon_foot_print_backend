package com.cruzroja.carbon_foot_print.Infrastucture.Output.Persistence.Entities;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * Clase de entidad que representa un usuario en la capa de persistencia.
 */
@Entity
@Table(name = "users")
@Inheritance(strategy = InheritanceType.JOINED)
@Data
@AllArgsConstructor
public class UserEntity implements UserDetails {

    /** Número de documento del usuario. */
    @Id
    private long documentNumber;

    /** Tipo de documento del usuario. */
    @Column(nullable = false, length = 45)
    private String documentType;

    /** Nombres del usuario. */
    @Column(nullable = false, length = 60)
    private String names;

    /** Apellidos del usuario. */
    @Column(nullable = false, length = 60)
    private String lastNames;

    /** Teléfono personal del usuario. */
    @Column(nullable = true, length = 12)
    private String personalPhone;

    /** Correo electrónico personal del usuario. */
    @Column(nullable = false, unique = true, length = 320)
    private String personalEmail;

    /** Nombre de usuario del usuario. */
    @Column(nullable = false, unique = true, length = 40)
    private String username;

    /** Contraseña del usuario. */
    @Column(nullable = false, length = 300)
    private String password;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "user_roles",
            joinColumns = @JoinColumn(name = "user_document_number"),
            inverseJoinColumns = @JoinColumn(name = "id_role"))
    private List<RoleEntity> roles;

    /** Estado del usuario. */
    @Column(nullable = false)
    private boolean state;

    /**
     * Constructor de la clase UserEntity. Inicializa la lista de roles.
     */
    public UserEntity() {
        this.roles = new ArrayList<>();
    }
     /**
     * Retorna una colección de objetos GrantedAuthority que representan los roles y permisos del usuario.
     * 
     * @return Colección de objetos GrantedAuthority que representan los roles y permisos del usuario.
     */
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<GrantedAuthority> authorities = new ArrayList<>();
        for (RoleEntity role : this.roles) {
            List<PermissionEntity> permissions = role.getPermissions();
            for (PermissionEntity permission : permissions) {
                authorities.add(new SimpleGrantedAuthority(permission.getName()));
            }
        }
        return authorities;
    }
    /**
     * Indica si la cuenta del usuario no ha expirado.
     * 
     * Retorna true si la cuenta del usuario no ha expirado, false de lo contrario.
     */
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    /**
     * Indica si la cuenta del usuario no está bloqueada.
     * 
     * Retorna true si la cuenta del usuario no está bloqueada, false de lo contrario.
     */
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    /**
     * Indica si las credenciales del usuario no han expirado.
     * 
     * Retorna true si las credenciales del usuario no han expirado, false de lo contrario.
     */
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    /**
     * Indica si el usuario está habilitado.
     * 
     * Retorna true si el usuario está habilitado, false de lo contrario.
     */
    @Override
    public boolean isEnabled() {
        return true;
    }

}
