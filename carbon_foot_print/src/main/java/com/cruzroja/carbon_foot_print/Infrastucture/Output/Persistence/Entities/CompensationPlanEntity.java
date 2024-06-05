package com.cruzroja.carbon_foot_print.Infrastucture.Output.Persistence.Entities;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;

@Entity
@Table(name = "Compensation_plans")
@Data
@AllArgsConstructor
public class CompensationPlanEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long planId;

    @Column(nullable = false, length = 45)
    private String planName;

    @Column(nullable = false)
    private double planPrice;

    @Column(nullable = false, length = 100)
    private String planDescription;

    @Column(nullable = false)
    private double planDiscount;

    @Column(nullable = false)
    private double planUfp;

    public CompensationPlanEntity() {
    }
}
