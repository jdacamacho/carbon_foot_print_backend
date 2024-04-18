package com.cruzroja.carbon_foot_print.Infrastucture.Output.Persistence.Entities;

import java.util.List;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "Volunteers")
@Getter
@Setter
@AllArgsConstructor
public class UserVolunteerEntity extends UserEntity {
    @Column(nullable = false, length = 45)
    private String position;

    public UserVolunteerEntity() {

    }

    public UserVolunteerEntity(long documentNumber, String documentType,
            String names, String lastNames, String personalPhone,
            String personalEmail, String username, String password,
            List<RoleEntity> roles, String position) {
        super(documentNumber, documentType,
                names, lastNames, personalPhone,
                personalEmail, username, password,
                roles, true);
        this.position = position;
    }

}
