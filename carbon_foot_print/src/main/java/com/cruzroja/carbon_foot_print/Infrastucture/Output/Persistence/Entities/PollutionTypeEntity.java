/**
 * @file PollutionTypeEntity.java
 * @brief Este archivo contiene la definición de la entidad PollutionTypeEntity para la persistencia de tipos de contaminación en la base de datos.
 */

 package com.cruzroja.carbon_foot_print.Infrastucture.Output.Persistence.Entities;

 import lombok.Getter;
 import lombok.Setter;
 
 import jakarta.persistence.Column;
 import jakarta.persistence.Entity;
 import jakarta.persistence.GeneratedValue;
 import jakarta.persistence.GenerationType;
 import jakarta.persistence.Id;
 import jakarta.persistence.Table;
 
 /**
  * @class PollutionTypeEntity
  * @brief Clase que representa la entidad PollutionTypeEntity para la persistencia de tipos de contaminación en la base de datos.
  */
 @Entity
 @Table(name = "pollution_types")
 @Getter
 @Setter
 public class PollutionTypeEntity {
     
     /** Identificador único del tipo de contaminación. */
     @Id
     @GeneratedValue(strategy = GenerationType.IDENTITY)
     private Long id;
 
     /** Nombre único del tipo de contaminación. */
     @Column(nullable = false, unique = true)
     private String name;
 
     /** Descripción del tipo de contaminación. */
     @Column(nullable = false)
     private String description;
 
     /** Factor de emisión del tipo de contaminación. */
     @Column(nullable = false)
     private double emissionFactor;
 
     /** Unidades de medida del factor de emisión del tipo de contaminación. */
     @Column(nullable = false)
     private String units;
 
     /**
      * Constructor vacío para PollutionTypeEntity.
      */
     public PollutionTypeEntity() {
     }
 
     /**
      * Constructor para crear una instancia de PollutionTypeEntity con todos los atributos.
      * @param name Nombre del tipo de contaminación.
      * @param description Descripción del tipo de contaminación.
      * @param emissionFactor Factor de emisión del tipo de contaminación.
      * @param units Unidades de medida del factor de emisión del tipo de contaminación.
      */
     public PollutionTypeEntity(String name, String description, double emissionFactor, String units) {
         this.name = name;
         this.description = description;
         this.emissionFactor = emissionFactor;
         this.units = units;
     }
 }
 