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

@CrossOrigin(origins = { "http://localhost:5050" })
@RestController
@RequestMapping("/api/categories")
@Validated
@RequiredArgsConstructor
public class CategoryRestController {
    private final ManegeCategoryCUIntPort categoryCU;
    private final MapperCategoryInfraestructureDomain mapper;

    /**
     * Endpoint que se encarga de recuperar todas las categorías con la información
     * básica registradas en el sistema.
     * 
     * @return {@code ResponseEntity<List<CategoryDTOResponse>>} en caso de éxito
     *         {@code ResponseEntity<Error>} en caso contrario.
     */
    @GetMapping("")
    @Transactional(readOnly = true)
    public ResponseEntity<List<CategoryDTOResponse>> listAll() {
        List<Category> categories = this.categoryCU.findAll();
        return new ResponseEntity<>(
                this.mapper.mapModelsToResponse(categories), HttpStatus.OK);
    }

    @GetMapping("/{categoryId}")
    @Transactional(readOnly = true)
    public ResponseEntity<CategoryDTOResponse> getCategory(@PathVariable long categoryId) {
        Category category = this.categoryCU.findById(categoryId);
        return new ResponseEntity<>(
                this.mapper.mapModelToResponse(category), HttpStatus.OK);
    }

    @GetMapping("/name")
    @Transactional(readOnly = true)
    public ResponseEntity<List<CategoryDTOResponse>> getCategoryBy(
            @RequestParam(required = true) @NotBlank(message = "The category name is required to find the categories.") String name) {
        List<Category> categories = this.categoryCU.findByName(name);
        return new ResponseEntity<>(
                this.mapper.mapModelsToResponse(categories), HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity<?> saveCategory(@RequestBody CategoryDTORequest request, BindingResult result) {
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

    @PostMapping("/ids")
    public ResponseEntity<?> getFullCategories(@RequestBody CategoryByIds request, BindingResult result) {
        Map<String, Object> response = new HashMap<>();
        response = this.catchErrors(result);
        if (response.isEmpty())
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

    @GetMapping("/enabled")
    public ResponseEntity<List<CategoryDTOResponse>> getCategoriesEnabled() {
        List<Category> categories = this.categoryCU.getAllEnable();
        return new ResponseEntity<>(
                this.mapper.mapModelsToResponse(categories), HttpStatus.OK);
    }

    @PostMapping("/enabled")
    public ResponseEntity<?> getFullEnabledCategories(@RequestBody CategoryByIds request, BindingResult result) {
        Map<String, Object> response = new HashMap<>();
        response = this.catchErrors(result);
        if (response.isEmpty())
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

    // @PatchMapping("")
    // public ResponseEntity<?> switchStatus(){

    // }

    private Map<String, Object> catchErrors(BindingResult result) {
        Map<String, Object> response = new HashMap<>();
        if (result.hasErrors()) {
            List<String> listaErrores = new ArrayList<>();

            for (FieldError error : result.getFieldErrors()) {
                listaErrores.add("The field '" + error.getField() + "‘ " + error.getDefaultMessage());
            }
            response.put("errors", listaErrores);
        }
        return response;

    }
}
