package com.cruzroja.carbon_foot_print.Infrastucture.Output.Persistence.Entities;

import com.cruzroja.carbon_foot_print.Domain.Models.User;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;

@Entity
@Table(name = "Volunteers")
@Data
@AllArgsConstructor
public class UserVolunteerEntity extends User {
    @Column(nullable = false, length = 45)
    private String position;
}
