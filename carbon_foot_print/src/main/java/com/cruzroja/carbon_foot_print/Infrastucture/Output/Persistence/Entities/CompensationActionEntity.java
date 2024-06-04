package com.cruzroja.carbon_foot_print.Infrastucture.Output.Persistence.Entities;

import com.cruzroja.carbon_foot_print.Infrastucture.Output.Persistence.Serealizables.CompensationActionId;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;

@Entity
@Table(name = "compensation_action")
@Data
@AllArgsConstructor
@IdClass(CompensationActionId.class)
public class CompensationActionEntity {
    @Id
    @ManyToOne
    @JoinColumn(name = "actionId")
    private ActionEntity action;
    @Id
    @ManyToOne
    @JoinColumn(name = "planId")
    private CompensationPlanEntity plan;

    @Column(nullable = false)
    private int compensationActionAmount;

    @Column(nullable = false)
    private int compensationActionPrice;

    @Column(nullable = false)
    private double compensationActionUfp;

    public CompensationActionEntity() {
    }
}
