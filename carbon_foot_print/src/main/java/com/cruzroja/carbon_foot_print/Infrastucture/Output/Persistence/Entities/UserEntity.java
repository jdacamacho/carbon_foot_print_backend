package com.cruzroja.carbon_foot_print.Infrastucture.Output.Persistence.Entities;

import java.util.ArrayList;
import java.util.List;

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
public class UserEntity {
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

    @Column(nullable = true , unique = true ,length = 320)
    private String personalEmail;

    @Column(nullable = false , unique = true ,length = 40)
    private String username;

    @Column(nullable = false , length = 300)
    private String password;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "user_roles",
        joinColumns = @JoinColumn(name = "user_document_number"),
        inverseJoinColumns = @JoinColumn(name = "id_role"))
    private List<RoleEntity> roles;

    @Column(nullable = false)
    private boolean state;

    public UserEntity(){
        this.roles = new ArrayList<>();
    }
}
