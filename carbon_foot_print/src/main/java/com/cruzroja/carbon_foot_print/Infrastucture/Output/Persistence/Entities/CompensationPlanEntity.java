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
import jakarta.persistence.JoinColumns;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;

@Entity
@Table(name = "CompensationPlans")
@Data
@AllArgsConstructor
public class CompensationPlanEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long planId;

    @Column(nullable = false, length = 100)
    private String planName;

    @Column(nullable = false)
    private double planPrice;

    @Column(nullable = false, length = 100)
    private String planDescription;

    @Column(nullable = false)
    private int planDiscount;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "plans_actions",
        joinColumns = @JoinColumn(name = "planId"),
        inverseJoinColumns = @JoinColumn(name = "actionId"))
    private List<ActionEntity> actions;

    public CompensationPlanEntity(){
        this.actions = new ArrayList<>();
    }
}
