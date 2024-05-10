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
@Table(name = "sources")
@AllArgsConstructor
@Data
public class SourceEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idSource;

    @Column(unique = true, length = 45, nullable = false)
    private String sourceName;

    public SourceEntity(){

    }
}
