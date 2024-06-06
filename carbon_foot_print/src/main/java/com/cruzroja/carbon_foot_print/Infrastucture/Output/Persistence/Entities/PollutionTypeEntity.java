/**
 * @file PollutionTypeEntity.java
 * @brief Este archivo contiene la definición de la entidad PollutionTypeEntity para la persistencia de tipos de contaminación en la base de datos.
 */

 package com.cruzroja.carbon_foot_print.Infrastucture.Output.Persistence.Entities;

 import java.util.List;
 import java.util.ArrayList;
 
 import lombok.AllArgsConstructor;
 import lombok.Data;
 
 import jakarta.persistence.Column;
 import jakarta.persistence.Entity;
 import jakarta.persistence.FetchType;
 import jakarta.persistence.GeneratedValue;
 import jakarta.persistence.GenerationType;
 import jakarta.persistence.Id;
 import jakarta.persistence.JoinColumn;
 import jakarta.persistence.JoinTable;
 import jakarta.persistence.ManyToMany;
 import jakarta.persistence.Table;
 
 /*Entidad que representa un tipo de contaminación.*/
 @Entity
 @Table(name = "pollution_types")
 @Data
 @AllArgsConstructor
 public class PollutionTypeEntity {
 
     /**Identificador único del tipo de contaminación.*/
     @Id
     @GeneratedValue(strategy = GenerationType.IDENTITY)
     private Long pollutionTypeId;
 
     /**
      * Nombre del tipo de contaminación.
      * No puede ser nulo, debe ser único y tiene una longitud máxima de 45 caracteres.
      */
     @Column(nullable = false, unique = true, length = 45)
     private String pollutionTypeName;
 
     /**
      * Descripción del tipo de contaminación.
      * No puede ser nulo y tiene una longitud máxima de 100 caracteres.
      */
     @Column(nullable = false, length = 100)
     private String pollutionTypeDescription;
 
     /**
      * Factor de emisión del tipo de contaminación.
      * No puede ser nulo.
      */
     @Column(nullable = false)
     private double pollutionTypeEmissionFactor;
 
     /**
      * Unidades del tipo de contaminación.
      * No puede ser nulo y tiene una longitud máxima de 45 caracteres.
      */
     @Column(nullable = false, length = 45)
     private String pollutionTypeUnits;
 
     /**
      * Lista de fuentes asociadas al tipo de contaminación.
      * Se carga con EAGER fetch type y se mapea con una tabla de unión llamada "pollution_source".
      */
     @ManyToMany(fetch = FetchType.EAGER)
     @JoinTable(
         name = "pollution_source",
         joinColumns = @JoinColumn(name = "pollution_id"),
         inverseJoinColumns = @JoinColumn(name = "source_id")
     )
     private List<SourceEntity> pollutionSources;
 
     /**
      * Constructor sin parámetros.
      * Inicializa la lista de fuentes de contaminación.
      */
     public PollutionTypeEntity() {
         this.pollutionSources = new ArrayList<SourceEntity>();
     }
 }
 