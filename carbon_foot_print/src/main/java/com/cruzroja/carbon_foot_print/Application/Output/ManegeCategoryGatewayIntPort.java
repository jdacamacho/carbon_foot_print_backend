/**
 * @file ManegeCategoryGatewayIntPort.java
 * @brief Interfaz para la gestión de categorías en el gateway de la aplicación.
 */

 package com.cruzroja.carbon_foot_print.Application.Output;

 import java.util.List;
 import com.cruzroja.carbon_foot_print.Domain.Models.Category;
 import com.cruzroja.carbon_foot_print.Domain.Models.PollutionType;
 
 /**
  * @interface ManegeCategoryGatewayIntPort
  * @brief Interfaz que define las operaciones de gestión de categorías en el gateway de la aplicación.
  * 
  * Esta interfaz proporciona los métodos necesarios para interactuar con el sistema de almacenamiento de datos
  * para crear, actualizar, recuperar y gestionar categorías y tipos de contaminación relacionados.
  */
 public interface ManegeCategoryGatewayIntPort {
 
     /**
      * @brief Crea una nueva categoría.
      * 
      * Este método permite registrar una nueva categoría en el sistema de almacenamiento de datos.
      * 
      * @param category La categoría a crear.
      * @return La categoría creada.
      */
     Category create(Category category);
 
     /**
      * @brief Actualiza una categoría existente.
      * 
      * Este método permite actualizar los detalles de una categoría ya existente.
      * 
      * @param category La categoría con los datos actualizados.
      * @return La categoría actualizada.
      */
     Category update(Category category);
 
     /**
      * @brief Encuentra una categoría por su identificador único.
      * 
      * Este método busca una categoría específica utilizando su identificador único.
      * 
      * @param id El identificador único de la categoría.
      * @return La categoría correspondiente al identificador proporcionado.
      */
     Category findById(long id);
 
     /**
      * @brief Recupera todas las categorías.
      * 
      * Este método devuelve una lista de todas las categorías almacenadas en el sistema.
      * 
      * @return Una lista de objetos de tipo Category que representan todas las categorías.
      */
     List<Category> findAll();
 
     /**
      * @brief Encuentra categorías por su nombre.
      * 
      * Este método busca categorías específicas utilizando su nombre.
      * 
      * @param name El nombre de la categoría a buscar.
      * @return Una lista de categorías que coinciden con el nombre especificado.
      */
     List<Category> findByName(String name);
 
     /**
      * @brief Recupera todas las categorías habilitadas.
      * 
      * Este método devuelve una lista de todas las categorías que están habilitadas en el sistema.
      * 
      * @return Una lista de objetos de tipo Category que representan todas las categorías habilitadas.
      */
     List<Category> getAllEnable();
 
     /**
      * @brief Recupera múltiples categorías por sus identificadores.
      * 
      * Este método devuelve una lista de categorías correspondientes a los identificadores proporcionados.
      * 
      * @param ids Una lista de identificadores únicos de las categorías.
      * @return Una lista de objetos de tipo Category que representan las categorías encontradas.
      */
     List<Category> getMoreById(List<Long> ids);
 
     /**
      * @brief Recupera múltiples categorías habilitadas por sus identificadores.
      * 
      * Este método devuelve una lista de categorías habilitadas correspondientes a los identificadores proporcionados.
      * 
      * @param ids Una lista de identificadores únicos de las categorías habilitadas.
      * @return Una lista de objetos de tipo Category que representan las categorías habilitadas encontradas.
      */
     List<Category> getMoreEnableById(List<Long> ids);
 
     /**
      * @brief Recupera todos los tipos de contaminación.
      * 
      * Este método devuelve una lista de todos los tipos de contaminación almacenados en el sistema.
      * 
      * @return Una lista de objetos de tipo PollutionType que representan todos los tipos de contaminación.
      */
     List<PollutionType> findAllPollutionTypes();
 
     /**
      * @brief Verifica si existe una categoría con un identificador específico.
      * 
      * Este método comprueba la existencia de una categoría utilizando su identificador único.
      * 
      * @param id El identificador único de la categoría cuya existencia se desea verificar.
      * @return true si la categoría existe, false en caso contrario.
      */
     boolean existsById(long id);
 
     /**
      * @brief Verifica si existe una categoría con un nombre específico.
      * 
      * Este método comprueba la existencia de una categoría utilizando su nombre.
      * 
      * @param name El nombre de la categoría cuya existencia se desea verificar.
      * @return true si la categoría existe, false en caso contrario.
      */
     boolean existsByName(String name);
 }
 