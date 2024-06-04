package com.cruzroja.carbon_foot_print.Domain.Models;

import lombok.AllArgsConstructor;
import lombok.Data;

/** Clase que representa una fuente de contaminación dentro del sistema de huella de carbono.*/
@Data
@AllArgsConstructor
public class PollutionSource {

    /**Tipo de contaminación asociado a la fuente.*/
    private PollutionType pollution;

    /**Fuente asociada a la contaminación. */
    private Source source;

    /** Constructor por defecto.*/
    public PollutionSource() {
    }
}
