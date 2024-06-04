package com.cruzroja.carbon_foot_print.Infrastucture.Output.Persistence.Entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;

@Entity
@Table(name = "actions")
@Data
@AllArgsConstructor
public class ActionEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long actionId;

    @Column(nullable = false, length = 45)
    private String actionName;

    @Column(nullable = false, length = 100)
    private String actionDescription;

    @Column(nullable = false)
    private double actionUnitaryPrice;

    @Column(nullable = false)
    private double actionUfp;

    public ActionEntity() {

    }

}
