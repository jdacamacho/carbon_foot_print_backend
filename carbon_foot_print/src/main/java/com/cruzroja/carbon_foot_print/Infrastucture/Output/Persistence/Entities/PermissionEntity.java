package com.cruzroja.carbon_foot_print.Infrastucture.Output.Persistence.Entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;

@Entity
@Table(name = "permissions")
@Data
@AllArgsConstructor
public class PermissionEntity {
    @Id
    private long idPermission;
    @Column(nullable = false , unique = true , length = 45)
    private String name;
    @Column(nullable = false , unique = false , length = 80)
    private String description;

    public PermissionEntity(){

    }

}
