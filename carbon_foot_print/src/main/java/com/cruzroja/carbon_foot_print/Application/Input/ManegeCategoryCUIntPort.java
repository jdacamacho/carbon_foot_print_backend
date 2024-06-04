/**
 * @file ManegeCategoryCUIntPort.java
 * @brief Interfaz para la gestión de categorías en la aplicación.
 */

 package com.cruzroja.carbon_foot_print.Application.Input;

 import java.util.List;
 import com.cruzroja.carbon_foot_print.Domain.Models.Category;
 
 /**
  * @interface ManegeCategoryCUIntPort
  * @brief Interfaz que define las operaciones de caso de uso para la gestión de categorías.
  * 
  * Esta interfaz proporciona los métodos necesarios para crear, actualizar, recuperar y gestionar categorías en la aplicación.
  */
 public interface ManegeCategoryCUIntPort {
 
     /**
      * @brief Crea una nueva categoría.
      * 
      * Este método permite registrar una nueva categoría en el sistema.
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
      * Este método devuelve una lista de todas las categorías registradas en el sistema.
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
 }
 