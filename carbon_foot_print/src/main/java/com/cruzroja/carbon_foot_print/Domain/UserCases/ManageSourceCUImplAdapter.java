/**
 * @archivo ManageSourceCUImplAdapter.java
 * @brief Este archivo contiene la implementación de la interfaz ManageSourceCUIntPort para gestionar fuentes relacionadas con cálculos de huella de carbono.
 */

package com.cruzroja.carbon_foot_print.Domain.UserCases;

import java.util.List;

import com.cruzroja.carbon_foot_print.Application.Input.ManageSourceCUIntPort;
import com.cruzroja.carbon_foot_print.Application.Output.ExceptionFormatterIntPort;
import com.cruzroja.carbon_foot_print.Application.Output.ManageSourceGatewayIntPort;
import com.cruzroja.carbon_foot_print.Domain.Models.Source;

/**
 * @clase ManageSourceCUImplAdapter
 * @brief Implementación de la interfaz ManageSourceCUIntPort para gestionar
 *        fuentes relacionadas con cálculos de huella de carbono.
 */
public class ManageSourceCUImplAdapter implements ManageSourceCUIntPort {

    /** El gateway para gestionar el acceso a datos de las fuentes. */
    private final ManageSourceGatewayIntPort gateway;

    /** El formateador para manejar excepciones. */
    private final ExceptionFormatterIntPort exceptionFormatter;

    /**
     * Constructor para ManageSourceCUImplAdapter.
     * 
     * @param gateway            El gateway para gestionar el acceso a datos de las
     *                           fuentes.
     * @param exceptionFormatter El formateador para manejar excepciones.
     */
    public ManageSourceCUImplAdapter(ManageSourceGatewayIntPort gateway,
            ExceptionFormatterIntPort exceptionFormatter) {
        this.gateway = gateway;
        this.exceptionFormatter = exceptionFormatter;
    }

    /**
     * Obtiene una lista de todas las fuentes.
     * 
     * @return Lista de objetos Source.
     */
    @Override
    public List<Source> listSources() {
        List<Source> sources = this.gateway.findAll();
        if (sources.size() == 0) {
            this.exceptionFormatter.returNoData("No se encontraron fuentes en el sistema");
        }
        return sources;
    }

    /**
     * Guarda una nueva fuente.
     * 
     * @param source El objeto Source a guardar.
     * @return El objeto Source guardado.
     */
    @Override
    public Source saveSource(Source source) {
        Source objResponse = null;
        if (this.gateway.existsByName(source.getSourceName())) {
            this.exceptionFormatter
                    .returnResponseErrorEntityExists("Ya existe una fuente con ese nombre en el sistema");
        }
        objResponse = this.gateway.save(source);
        return objResponse;

    }

    /**
     * Actualiza una fuente existente.
     * 
     * @param source El objeto Source a actualizar.
     * @return El objeto Source actualizado.
     */
    @Override
    public Source updateSource(Source source) {
        Source objResponse = null;
        if (!this.gateway.existsById(source.getIdSource())) {
            this.exceptionFormatter.returnResponseErrorEntityNotFound("Fuente no encontrada en el sistema con ese ID");
        } else {
            Source sourceObtained = this.gateway.findById(source.getIdSource());
            if (this.gateway.existsByName(source.getSourceName())) {
                if (!sourceObtained.verifySourceName(source.getSourceName())) {
                    this.exceptionFormatter
                            .returnResponseErrorEntityExists("Ya existe una fuente en el sistema con ese nombre");
                }
            }
            // TODO: Crear método update en Source (responsabilidad única)
            sourceObtained.setSourceName(source.getSourceName());
            sourceObtained.setSourceDescription(source.getSourceDescription());
            objResponse = this.gateway.save(sourceObtained);
        }
        return objResponse;
    }

    /**
     * Encuentra una fuente por su ID.
     * 
     * @param idSource El ID de la fuente a encontrar.
     * @return El objeto Source encontrado.
     */
    @Override
    public Source findByIdSource(long idSource) {
        Source objResponse = null;
        if (!this.gateway.existsById(idSource)) {
            this.exceptionFormatter.returNoData("Fuente con ese ID no encontrada en el sistema");
        }
        objResponse = this.gateway.findById(idSource);
        return objResponse;
    }

    /**
     * Encuentra una fuente por su nombre.
     * 
     * @param sourceName El nombre de la fuente a encontrar.
     * @return El objeto Source encontrado.
     */
    @Override
    public Source findBySourceName(String sourceName) {
        Source objResponse = null;
        if (!this.gateway.existsByName(sourceName)) {
            this.exceptionFormatter.returNoData("Fuente con ese ID no encontrada en el sistema");
        }
        objResponse = this.gateway.findByName(sourceName);
        return objResponse;
    }
}
