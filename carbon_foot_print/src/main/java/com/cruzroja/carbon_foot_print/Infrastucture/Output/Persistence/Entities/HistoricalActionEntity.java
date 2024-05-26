package com.cruzroja.carbon_foot_print.Infrastucture.Output.Persistence.Entities;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;

@Entity
@Table(name = "historicalAction")
@Data
@AllArgsConstructor
public class HistoricalActionEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long historicalActionId;

    @Column(nullable = false, length = 45, updatable = false)
    private String historicalActionName;

    @Column(nullable = false, length = 100, updatable = false)
    private String historicalActionDescription;

    @Column(nullable = false, updatable = false)
    private double historicalActionUnitaryPrice;
    @Column(nullable = false, updatable = false)
    private Date histaricalActionEffectiveDate;
    @Column(nullable = true)
    private Date histaricalActionCloseDate;
    @Id
    @ManyToOne
    @JoinColumn(name = "actionId")
    ActionEntity action;

    public HistoricalActionEntity() {
    }
}
