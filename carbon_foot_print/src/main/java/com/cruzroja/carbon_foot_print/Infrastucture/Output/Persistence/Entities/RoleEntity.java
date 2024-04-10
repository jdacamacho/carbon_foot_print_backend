package com.cruzroja.carbon_foot_print.Infrastucture.Output.Persistence.Entities;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;

@Entity
@Table(name = "roles")
@Data
@AllArgsConstructor
public class RoleEntity {
    @Id
    private long idRole;

    @Column(nullable = false , unique = true , length = 45)
    private String typeRole;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "role_permissions",
        joinColumns = @JoinColumn(name = "idRole"),
        inverseJoinColumns = @JoinColumn(name = "idPermission"))
    private List<PermissionEntity> permissions;

    public RoleEntity(){
        this.permissions = new ArrayList<>();
    }
}
