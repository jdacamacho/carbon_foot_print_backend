package com.cruzroja.carbon_foot_print.Infrastucture.Output.Persistence.Entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;

@Entity
@Table(name = "roles")
@Data
@AllArgsConstructor
public class RoleEntity {
    @Id
    @Column(name = "role_id")
    private long id;
    @Column(name = "role_name",nullable = false , unique = true , length = 45)
    private String typeRole;

    public RoleEntity(){

    }
}
