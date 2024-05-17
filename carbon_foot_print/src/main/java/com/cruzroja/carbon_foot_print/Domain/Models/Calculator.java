package com.cruzroja.carbon_foot_print.Domain.Models;

import lombok.Getter;

@Getter
public class Calculator {
    private PollutionSource pollutionSource;
    private int month;
    private int year;
    private double consume;
    private double cost;
    private int sources;
    private int informedSources;
    private double coverge;
    private double footPrint;

    public Calculator() {
    }

    public Calculator(PollutionSource pollutionSource, int month, int year, double consume, double cost, int sources,
            int informedSources) {
        this.pollutionSource = pollutionSource;
        this.month = month;
        this.year = year;
        this.consume = consume;
        this.cost = cost;
        this.sources = sources;
        this.informedSources = informedSources;
        calcule();
    }

    public void update(Calculator calculator) {
        this.consume = calculator.consume;
        this.cost = calculator.cost;
        this.sources = calculator.sources;
        this.informedSources = calculator.informedSources;
        calcule();
    }

    /**
     * Calcula a cobertura del dato, tiendo en cuenta el número de fuentes totales y
     * las fuentes informadas bajo una formula simple de cálculo de porcentaje
     * {@code (informadas/totales)* 100}. En caso de que el número de totales sea
     * {@code 0} se protege el sistema asignando {@code -1} a la covertura.
     */
    private void calculeCoverge() {
        if (this.sources > 0)
            this.coverge = (this.informedSources / this.sources) * 100;
        else
            this.coverge = 0;
    }

    /**
     * Calcula la huella de carbono del registro tomando la información de factor de
     * emisión del pollution type y el consumo registrado por la empresa.
     */
    private void calculeFootPrint() {
        this.footPrint = this.pollutionSource.getPollution().getPollutionTypeEmissionFactor() * this.consume;
    }

    /**
     * Realiza el cálculo de los atributos no ingresados por el constructor.
     */
    public void calcule() {
        calculeCoverge();
        calculeFootPrint();
    }

}
