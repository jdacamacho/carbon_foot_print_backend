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
    private long id;
    @Column(nullable = false , unique = true , length = 45)
    private String typeRole;

    public RoleEntity(){

    }
}
