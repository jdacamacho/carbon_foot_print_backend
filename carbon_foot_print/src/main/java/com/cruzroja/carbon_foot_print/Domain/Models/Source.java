package com.cruzroja.carbon_foot_print.Domain.Models;

/**
 * Representa una fuente de emisión de contaminación en la aplicación de huella de carbono.
 */
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Source {

    /** Identificador único de la fuente. */
    private long idSource;

    /** Nombre de la fuente. */
    private String sourceName;
    /** Descripción de la fuente. */
    private String sourceDescription;

    /**
     * Constructor de la clase Source.
     */
    public Source() {

    }

    /**
     * Verifica si el nombre de la fuente coincide con el nombre proporcionado.
     * 
     * @param sourceName Nombre de la fuente a verificar.
     * @return true si el nombre de la fuente coincide con el nombre proporcionado,
     *         false de lo contrario.
     */
    public boolean verifySourceName(String sourceName) {
        return this.sourceName.equals(sourceName);
    }

}
