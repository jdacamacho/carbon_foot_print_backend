package com.cruzroja.carbon_foot_print.Domain.Models;

import lombok.AllArgsConstructor;
import lombok.Data;

/*Representa la contaminación generada por una empresa en un período específico.*/
@Data
@AllArgsConstructor
public class CompanyPollution {
    /*Identificador único de la contaminación.*/
    private long pollutionId;

    /*Identificador único de la fuente de contaminación.*/
    private long sourceId;

    /*Año en el que se registra la contaminación.*/
    private int year;

    /*Mes en el que se registra la contaminación.*/
    private int month;

    /*Cantidad de consumo asociado a la contaminación (por ejemplo, consumo de energía).*/
    private double consume;

    /*Costo asociado a la contaminación*/
    private double cost;

    /*Fuente informada de la contaminación.*/
    private int informedSource;

    /*Total de fuentes asociadas a la contaminación.*/
    private int totalSource;

    /*Constructor vacío de la clase CompanyPollution.*/
    public CompanyPollution() {
    }
}
