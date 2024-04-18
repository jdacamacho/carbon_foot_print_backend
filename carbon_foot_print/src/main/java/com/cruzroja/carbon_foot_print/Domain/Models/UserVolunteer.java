package com.cruzroja.carbon_foot_print.Domain.Models;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class UserVolunteer extends User {
    private String position;

    public UserVolunteer() {

    }

    public UserVolunteer(long documentNumber, String documentType,
            String names, String lastNames, String personalPhone,
            String personalEmail, String username, String password,
            List<Role> roles, String position) {
        super(documentNumber, documentType,
                names, lastNames, personalPhone,
                personalEmail, username, password,
                roles, true);
        this.position = position;
    }

    public void update(UserVolunteer volunteer) {
        super.update(volunteer);
        this.position = volunteer.getPosition();
    }
}
