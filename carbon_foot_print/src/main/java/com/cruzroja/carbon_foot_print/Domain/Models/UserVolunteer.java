package com.cruzroja.carbon_foot_print.Domain.Models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
@AllArgsConstructor
public class UserVolunteer extends User {
    private String position;

    public void update(UserVolunteer volunteer) {
        super.update(volunteer);
        this.position = volunteer.getPosition();
    }

}
