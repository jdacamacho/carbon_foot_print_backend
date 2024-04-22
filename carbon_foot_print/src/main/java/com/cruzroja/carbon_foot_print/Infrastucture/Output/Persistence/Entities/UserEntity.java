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

@Entity
@Table(name = "users")
@Inheritance(strategy  = InheritanceType.JOINED)
@Data
@AllArgsConstructor
public class UserEntity implements UserDetails{
    @Id
    private long documentNumber;

    @Column(nullable =  false , length = 45)
    private String documentType;

    @Column(nullable = false , length = 60)
    private String names;

    @Column( nullable = false , length = 60)
    private String lastNames;

    @Column(nullable = true, length = 12)
    private String personalPhone;

    @Column(nullable = false , unique = true ,length = 320)
    private String personalEmail;

    @Column(nullable = false , unique = true ,length = 40)
    private String username;

    @Column(nullable = false , length = 300)
    private String password;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "user_roles",
        joinColumns = @JoinColumn(name = "user_document_number"),
        inverseJoinColumns = @JoinColumn(name = "id_role"))
    private List<RoleEntity> roles;

    @Column(nullable = false)
    private boolean state;

    public UserEntity(){
        this.roles = new ArrayList<>();
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<GrantedAuthority> authorities = new ArrayList<>();
        for(RoleEntity role : this.roles){
            List<PermissionEntity> permissions = role.getPermissions();
            for(PermissionEntity permission : permissions){
                authorities.add(new SimpleGrantedAuthority(permission.getName()));
            }
        }
        return authorities;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
