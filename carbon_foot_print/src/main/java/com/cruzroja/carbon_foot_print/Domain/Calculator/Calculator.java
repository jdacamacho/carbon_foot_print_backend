package com.cruzroja.carbon_foot_print.Domain.Calculator;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import com.cruzroja.carbon_foot_print.Domain.Models.DataCalculator;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
/**
 * Clase del dominio (core de la aplicación): Su función es recibir los datos en
 * una lista ({@code DataCalculator}) y procesarlos con el fin de retornar la
 * medición total de huella de carbono y datos adicionales defiidos en
 * {@code CalculatorResponse}
 */
public class Calculator {
    /** Total de huella de carbono */
    private double footPrint;
    /** Datos para realizar el cálculo */
    private List<DataCalculator> data;
    /** Respuesta calculada */
    private CalculatorResponse results;

    public Calculator() {
        this.data = new ArrayList<DataCalculator>();
        this.footPrint = 0;
        this.results = new CalculatorResponse();
    }

    public Calculator(List<DataCalculator> data) {
        this.footPrint = 0;
        this.data = data;
        this.results = new CalculatorResponse();
    }

    /**
     * Determina si un dato se encuentra repetivo a través del uso de una PK, UUID o
     * patrón IDO compuesto por el {@code year}, {@code month} y
     * ({@code pollutionId}, ({@code sourceId})) correspondientes al
     * ({@code PollutionSource}).
     * 
     * @return {@code true} en caso de que hayan 2 elementos con mismo UUID y
     *         {@code false} en caso contrario.
     */
    public boolean isDuplicate() {
        Set<String> uniqueCombinationSet = new HashSet<>();

        for (DataCalculator dataCalculator : this.data) {
            String key = dataCalculator.getYear() + "-" + dataCalculator.getMonth() + "-"
                    + dataCalculator.getPollutionId() + "-"
                    + dataCalculator.getSourceId();

            if (!uniqueCombinationSet.add(key))
                return true;
        }
        return false;
    }

    /**
     * Agrupa los datos en un Map tomando como criterio el atributo {@code year}.
     * 
     * @return {@code Map<Integer, List<DataCalculator>>} datos agrupados por año
     */
    private Map<Integer, List<DataCalculator>> groupByYear() {
        return this.data.stream()
                .collect(Collectors.groupingBy(DataCalculator::getYear));
    }

    /**
     * Agrupa por {@code month} el de datos recibido, también ordena los datos por
     * mes y rellena los datos de los meses faltantes.
     * 
     * @param dataYear Datos agrupados por año.
     * @return {@code  Map<Integer, List<DataCalculator>>} datos agrupados por mes
     */
    private Map<Integer, List<DataCalculator>> groupByMonth(List<DataCalculator> dataYear) {
        Map<Integer, List<DataCalculator>> dataMonthly = dataYear.stream()
                .collect(Collectors.groupingBy(DataCalculator::getMonth));
        for (int i = 12; i > 0; i--) {
            if (dataMonthly.get(i) == null)
                dataMonthly.put(i, new ArrayList<DataCalculator>());
        }

        return dataMonthly;
    }

    /**
     * Agrupa los datos tomando como criterio el {@code sourceId}
     * 
     * @return {@code  Map<Long, List<DataCalculator>>} mapa con los datos agrupados
     *         por fuente.
     */
    private Map<Long, List<DataCalculator>> groupBySource() {
        return this.data.stream()
                .collect(Collectors.groupingBy(DataCalculator::getSourceId));
    }

    /**
     * Calcula la huella de carbono generada por cada dato registrado dentro de la
     * lista y calcula el total.
     * 
     * @param data lista de datos a evaluar.
     * @return {@code double} total de polución generada por los items de la lista.
     */
    public double calculateInList(List<DataCalculator> data) {
        double pollution = 0;
        if (data.isEmpty())
            return pollution;
        for (DataCalculator dc : data) {
            pollution += dc.calculeFootPrint();
        }
        return pollution;
    }

    /**
     * Se encarga de calcular la polución anual generada, guarda los datos en el
     * {@code CalculatorResponse}
     */
    public void calculateAnnual() {
        Map<Integer, List<DataCalculator>> annualData = groupByYear();
        annualData.forEach((k, v) -> {
            Map<Integer, List<DataCalculator>> monthlyData = groupByMonth(v);
            MonthResult monthlyResult = new MonthResult(k, new ArrayList<Double>(), 0);
            for (int i = 1; i < 13; i++)
                monthlyResult.addMonth(this.calculateInList(monthlyData.get(i)));
            this.results.addMonth(monthlyResult);

        });
    }

    /**
     * Se encarga de calcular la polución generada discriminando por las fuentes que
     * la generan, guarda los datos en el {@code CalculatorResponse}
     */
    public void calculateBySource() {
        Map<Long, List<DataCalculator>> dataSource = this.groupBySource();
        dataSource.forEach((k, v) -> {
            SourceResult result = new SourceResult(v.get(0).getPollutionSource().getSource().getSourceName(),
                    this.calculateInList(v));
            this.results.addSource(result);
        });
    }

    /**
     * Se encarga de actualizar el {@code CalculatorResponse} se sugiere utilizar
     * previo al {@code getResults}
     */
    public void calcule() {
        calculateAnnual();
        calculateBySource();
        this.results.calculePercentage();
    }

}
