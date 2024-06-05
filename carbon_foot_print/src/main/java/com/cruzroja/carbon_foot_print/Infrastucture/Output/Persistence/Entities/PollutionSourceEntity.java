package com.cruzroja.carbon_foot_print.Infrastucture.Output.Persistence.Entities;

import com.cruzroja.carbon_foot_print.Infrastucture.Output.Persistence.Serealizables.PollutionSourceId;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;

/**Entidad que representa una fuente de contaminación.*/
@Entity
@Table(name = "pollution_source")
@Data
@AllArgsConstructor
@IdClass(PollutionSourceId.class)
public class PollutionSourceEntity {

    /**
     * La fuente asociada a la contaminación.
     * Representada por una entidad de tipo SourceEntity.
     */
    @Id
    @ManyToOne
    @JoinColumn(name = "source_id", nullable = false)
    private SourceEntity source;

    /**
     * El tipo de contaminación asociado a la fuente.
     * Representado por una entidad de tipo PollutionTypeEntity.
     */
    @Id
    @ManyToOne
    @JoinColumn(name = "pollution_id", nullable = false)
    private PollutionTypeEntity pollution;

    /*Constructor sin parámetros.*/
    public PollutionSourceEntity() {
    }
}

