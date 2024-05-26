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
@Table(name = "historicalAction")
@Data
@AllArgsConstructor
public class HistoricalActionEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long historicalActionId;

    @Column(nullable = false, length = 45)
    private String historicalActionName;

    @Column(nullable = false, length = 100)
    private String historicalActionDescription;

    @Column(nullable = false)
    private double historicalActionUnitaryPrice;

    public HistoricalActionEntity() {
    }
}
