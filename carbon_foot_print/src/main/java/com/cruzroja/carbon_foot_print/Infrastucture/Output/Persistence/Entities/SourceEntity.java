/**
 * @file SourceEntity.java
 * @brief Este archivo contiene la definición de la entidad SourceEntity para la persistencia de fuentes en la base de datos.
 */

 package com.cruzroja.carbon_foot_print.Infrastucture.Output.Persistence.Entities;

 import jakarta.persistence.Column;
 import jakarta.persistence.Entity;
 import jakarta.persistence.GeneratedValue;
 import jakarta.persistence.GenerationType;
 import jakarta.persistence.Id;
 import jakarta.persistence.Table;
 import lombok.AllArgsConstructor;
 import lombok.Data;
 
 /**
  * @class SourceEntity
  * @brief Clase que representa la entidad SourceEntity para la persistencia de fuentes en la base de datos.
  */
 @Entity
 @Table(name = "sources")
 @AllArgsConstructor
 @Data
 public class SourceEntity {
     
     /** Identificador único de la fuente. */
     @Id
     @GeneratedValue(strategy = GenerationType.IDENTITY)
     private long idSource;
 
     /** Nombre único de la fuente. */
     @Column(unique = true, length = 45, nullable = false)
     private String sourceName;
 
     /**
      * Constructor vacío para SourceEntity.
      */
     public SourceEntity(){
 
     }
 }
 