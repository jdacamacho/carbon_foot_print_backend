package com.cruzroja.carbon_foot_print.Domain.Models;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @class DataCalculator
 * @brief Clase que representa los datos necesarios para calcular la huella de carbono.
 *
 * La clase DataCalculator encapsula la información requerida para calcular la huella de carbono 
 * de una fuente de contaminación específica y proporciona métodos para realizar varios cálculos relacionados.
 */
@Data
@AllArgsConstructor
public class DataCalculator {

    /**
     * @brief Fuente de contaminación asociada con estos datos.
     */
    private PollutionSource pollutionSource;

    /**
     * @brief Identificador único de la contaminación.
     */
    private long pollutionId;

    /**
     * @brief Identificador único de la fuente de contaminación.
     */
    private long sourceId;

    /**
     * @brief Mes en que se registran los datos.
     */
    private int month;

    /**
     * @brief Año en que se registran los datos.
     */
    private int year;

    /**
     * @brief Consumo registrado para la fuente de contaminación.
     */
    private double consume;

    /**
     * @brief Costo asociado con el consumo registrado.
     */
    private double cost;

    /**
     * @brief Número total de fuentes.
     */
    private int sources;

    /**
     * @brief Número de fuentes informadas.
     */
    private int informedSources;

    /**
     * @brief Cobertura calculada en porcentaje.
     */
    private double coverge;

    /**
     * @brief Huella de carbono calculada.
     */
    private double footPrint;

    /**
     * @brief Constructor por defecto.
     *
     * Crea una instancia de DataCalculator sin inicializar los atributos. 
     * Es necesario para el mvnw.
     */
    public DataCalculator() {
    }

    /**
     * @brief Establece la fuente de contaminación y recalcula la huella de carbono.
     *
     * @param pollutionSource La nueva fuente de contaminación.
     */
    public void setPollutionSource(PollutionSource pollutionSource) {
        this.pollutionSource = pollutionSource;
        this.footPrint = calculeFootPrint();
    }

    /**
     * @brief Calcula la cobertura en porcentaje.
     *
     * @return Porcentaje de cobertura calculado.
     */
    public double calculeCoverge() {
        if (this.sources > 0)
            return ((double)this.informedSources / this.sources) * 100;
        return 0;
    }

    /**
     * @brief Calcula la huella de carbono.
     *
     * @return Huella de carbono calculada.
     */
    public double calculeFootPrint() {
        return this.consume * this.pollutionSource.getPollution().getPollutionTypeEmissionFactor();
    }

    /**
     * @brief Verifica si la cobertura es válida.
     *
     * @return true si la cobertura es válida, false en caso contrario.
     */
    public boolean isValidCoverge() {
        return this.informedSources <= this.sources;
    }

    /**
     * @brief Calcula todos los datos relacionados (huella de carbono y cobertura).
     */
    public void calculeData() {
        this.footPrint = calculeFootPrint();
        this.coverge = calculeCoverge();
    }
}
