/**
 * @file CategoryRestController.java
 * @brief Controlador REST para gestionar las categorías.
 */

 package com.cruzroja.carbon_foot_print.Infrastucture.Input.ControllerManegeCategory.Controller;

 import java.util.ArrayList;
 import java.util.HashMap;
 import java.util.List;
 import java.util.Map;
 
 import org.springframework.dao.DataAccessException;
 import org.springframework.http.HttpStatus;
 import org.springframework.http.ResponseEntity;
 import org.springframework.validation.BindingResult;
 import org.springframework.validation.FieldError;
 import org.springframework.validation.annotation.Validated;
 import org.springframework.web.bind.annotation.CrossOrigin;
 import org.springframework.web.bind.annotation.GetMapping;
 import org.springframework.web.bind.annotation.PathVariable;
 import org.springframework.web.bind.annotation.RequestMapping;
 import org.springframework.web.bind.annotation.RequestParam;
 import org.springframework.web.bind.annotation.RestController;
 
 import com.cruzroja.carbon_foot_print.Application.Input.ManegeCategoryCUIntPort;
 import com.cruzroja.carbon_foot_print.Domain.Models.Category;
 import com.cruzroja.carbon_foot_print.Infrastucture.Input.ControllerManegeCategory.DTORequest.CategoryByIds;
 import com.cruzroja.carbon_foot_print.Infrastucture.Input.ControllerManegeCategory.DTORequest.CategoryDTORequest;
 import com.cruzroja.carbon_foot_print.Infrastucture.Input.ControllerManegeCategory.DTORequest.CategoryWithIdDTORequest;
 import com.cruzroja.carbon_foot_print.Infrastucture.Input.ControllerManegeCategory.DTOResponse.CategoryDTOResponse;
 import com.cruzroja.carbon_foot_print.Infrastucture.Input.ControllerManegeCategory.DTOResponse.CategoryWithRelationDTOResponse;
 import com.cruzroja.carbon_foot_print.Infrastucture.Input.ControllerManegeCategory.mappers.MapperCategoryInfraestructureDomain;
 
 import jakarta.validation.Valid;
 import jakarta.validation.constraints.NotBlank;
 
 import org.springframework.transaction.annotation.Transactional;
 import lombok.RequiredArgsConstructor;
 import org.springframework.web.bind.annotation.PostMapping;
 import org.springframework.web.bind.annotation.RequestBody;
 import org.springframework.web.bind.annotation.PutMapping;
 
 /**
  * @class CategoryRestController
  * @brief Controlador REST para gestionar las categorías.
  * 
  * Este controlador proporciona endpoints para crear, actualizar, recuperar y listar categorías.
  */
 @CrossOrigin(origins = { "http://localhost:5050" })
 @RestController
 @RequestMapping("/api/categories")
 @Validated
 @RequiredArgsConstructor
 public class CategoryRestController {
 
     /** @brief Caso de uso para gestionar las categorías. */
     private final ManegeCategoryCUIntPort categoryCU;
 
     /** @brief Mapper para convertir entre DTOs y modelos de dominio. */
     private final MapperCategoryInfraestructureDomain mapper;
 
     /**
      * @brief Recupera todas las categorías con la información básica.
      * 
      * @return {@code ResponseEntity<List<CategoryDTOResponse>>} en caso de éxito.
      */
     @GetMapping("")
     @Transactional(readOnly = true)
     public ResponseEntity<List<CategoryDTOResponse>> listAll() {
         List<Category> categories = this.categoryCU.findAll();
         return new ResponseEntity<>(
                 this.mapper.mapModelsToResponse(categories), HttpStatus.OK);
     }
 
     /**
      * @brief Recupera una categoría por su ID.
      * 
      * @param categoryId El identificador único de la categoría.
      * @return {@code ResponseEntity<CategoryDTOResponse>} en caso de éxito.
      */
     @GetMapping("/{categoryId}")
     @Transactional(readOnly = true)
     public ResponseEntity<CategoryDTOResponse> getCategory(@PathVariable long categoryId) {
         Category category = this.categoryCU.findById(categoryId);
         return new ResponseEntity<>(
                 this.mapper.mapModelToResponse(category), HttpStatus.OK);
     }
 
     /**
      * @brief Recupera una categoría por su nombre.
      * 
      * @param name El nombre de la categoría.
      * @return {@code ResponseEntity<List<CategoryDTOResponse>>} en caso de éxito.
      */
     @GetMapping("/name")
     @Transactional(readOnly = true)
     public ResponseEntity<List<CategoryDTOResponse>> getCategoryBy(
             @RequestParam(required = true) @NotBlank(message = "The category name is required to find the categories.") String name) {
         List<Category> categories = this.categoryCU.findByName(name);
         return new ResponseEntity<>(
                 this.mapper.mapModelsToResponse(categories), HttpStatus.OK);
     }
 
     /**
      * @brief Guarda una nueva categoría.
      * 
      * @param request El objeto CategoryDTORequest con los datos de la categoría.
      * @param result El resultado de la validación del objeto de solicitud.
      * @return {@code ResponseEntity<CategoryWithRelationDTOResponse>} en caso de éxito.
      *         {@code ResponseEntity<Map<String, Object>>} en caso de error.
      */
     @PostMapping("")
     public ResponseEntity<?> saveCategory(@Valid @RequestBody CategoryDTORequest request, BindingResult result) {
         Category category = this.mapper.mapRequestModel(request);
         Map<String, Object> response = new HashMap<>();
         response = this.catchErrors(result);
         if (response.size() != 0)
             return new ResponseEntity<Map<String, Object>>(response, HttpStatus.BAD_REQUEST);
         try {
             CategoryWithRelationDTOResponse objCategory = this.mapper
                     .mapModelToFullResponse(this.categoryCU.create(category));
             return new ResponseEntity<CategoryWithRelationDTOResponse>(objCategory, HttpStatus.CREATED);
         } catch (DataAccessException e) {
             response.put("mensaje", "Error when inserting into database");
             response.put("error", e.getMessage() + "" + e.getMostSpecificCause().getMessage());
             return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
         }
     }
 
     /**
      * @brief Recupera categorías completas por sus IDs.
      * 
      * @param request El objeto CategoryByIds con los IDs de las categorías.
      * @param result El resultado de la validación del objeto de solicitud.
      * @return {@code ResponseEntity<List<CategoryWithRelationDTOResponse>>} en caso de éxito.
      *         {@code ResponseEntity<Map<String, Object>>} en caso de error.
      */
     @PostMapping("/ids")
     public ResponseEntity<?> getFullCategories(@Valid @RequestBody CategoryByIds request, BindingResult result) {
         Map<String, Object> response = new HashMap<>();
         response = this.catchErrors(result);
         if (!response.isEmpty())
             return new ResponseEntity<Map<String, Object>>(response, HttpStatus.BAD_REQUEST);
         try {
             List<CategoryWithRelationDTOResponse> objCategories = this.mapper
                     .mapModelsToFullResponse(this.categoryCU.getMoreById(request.getIds()));
             return new ResponseEntity<List<CategoryWithRelationDTOResponse>>(objCategories, HttpStatus.OK);
         } catch (DataAccessException e) {
             response.put("mensaje", "Error when searching into database");
             response.put("error", e.getMessage() + "" + e.getMostSpecificCause().getMessage());
             return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
         }
     }
 
     /**
      * @brief Recupera todas las categorías habilitadas.
      * 
      * @return {@code ResponseEntity<List<CategoryDTOResponse>>} en caso de éxito.
      */
     @GetMapping("/enabled")
     public ResponseEntity<List<CategoryDTOResponse>> getCategoriesEnabled() {
         List<Category> categories = this.categoryCU.getAllEnable();
         return new ResponseEntity<>(
                 this.mapper.mapModelsToResponse(categories), HttpStatus.OK);
     }
 
     /**
      * @brief Recupera categorías completas habilitadas por sus IDs.
      * 
      * @param request El objeto CategoryByIds con los IDs de las categorías.
      * @param result El resultado de la validación del objeto de solicitud.
      * @return {@code ResponseEntity<List<CategoryWithRelationDTOResponse>>} en caso de éxito.
      *         {@code ResponseEntity<Map<String, Object>>} en caso de error.
      */
     @PostMapping("/enabled")
     public ResponseEntity<?> getFullEnabledCategories(@Valid @RequestBody CategoryByIds request, BindingResult result) {
         Map<String, Object> response = new HashMap<>();
         response = this.catchErrors(result);
         if (!response.isEmpty())
             return new ResponseEntity<Map<String, Object>>(response, HttpStatus.BAD_REQUEST);
         try {
             List<CategoryWithRelationDTOResponse> objCategories = this.mapper
                     .mapModelsToFullResponse(this.categoryCU.getMoreEnableById(request.getIds()));
             return new ResponseEntity<List<CategoryWithRelationDTOResponse>>(objCategories, HttpStatus.OK);
         } catch (DataAccessException e) {
             response.put("mensaje", "Error when searching into database");
             response.put("error", e.getMessage() + "" + e.getMostSpecificCause().getMessage());
             return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
         }
     }
 
     /**
      * @brief Actualiza una categoría existente.
      * 
      * @param request El objeto CategoryWithIdDTORequest con los datos de la categoría.
      * @param result El resultado de la validación del objeto de solicitud.
      * @return {@code ResponseEntity<CategoryDTOResponse>} en caso de éxito.
      *         {@code ResponseEntity<Map<String, Object>>} en caso de error.
      */
     @PutMapping("")
     public ResponseEntity<?> updateUserVolunteer(@Valid @RequestBody CategoryWithIdDTORequest request,
             BindingResult result) {
         Category category = this.mapper.mapRequestModel(request);
         Map<String, Object> response = new HashMap<>();
         response = this.catchErrors(result);
         if (response.size() != 0)
             new ResponseEntity<Map<String, Object>>(response, HttpStatus.BAD_REQUEST);
         try {
             CategoryDTOResponse objCategory = this.mapper.mapModelToResponse(this.categoryCU.update(category));
             return new ResponseEntity<CategoryDTOResponse>(objCategory, HttpStatus.OK);
         } catch (DataAccessException e) {
             response.put("mensaje", "Error when inserting into database");
             response.put("error", e.getMessage() + "" + e.getMostSpecificCause().getMessage());
             return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
         }
     }
 
     /**
      * @brief Maneja los errores de validación.
      * 
      * @param result El resultado de la validación.
      * @return Un mapa de errores.
      */
     private Map<String, Object> catchErrors(BindingResult result) {
         Map<String, Object> response = new HashMap<>();
         if (result.hasErrors()) {
             List<String> listaErrores = new ArrayList<>();
 
             for (FieldError error : result.getFieldErrors()) {
                 listaErrores.add("The field '" + error.getField() + "' " + error.getDefaultMessage());
             }
             response.put("errors", listaErrores);
         }
         return response;
     }
 }
 