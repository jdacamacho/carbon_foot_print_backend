package com.cruzroja.carbon_foot_print.Application.Output;

import java.util.List;

import com.cruzroja.carbon_foot_print.Domain.Models.Category;
import com.cruzroja.carbon_foot_print.Domain.Models.PollutionType;

public interface ManegeCategoryGatewayIntPort {
    Category create(Category category);

    Category update(Category category);

    Category findById(long id);

    List<Category> findAll();

    List<Category> findByName(String name);

    List<Category> getAllEnable();

    List<Category> getMoreById(List<Long> ids);

    List<Category> getMoreEnableById(List<Long> ids);

    List<PollutionType> findAllPollutionTypes();

    boolean existsById(long id);

    boolean existsByName(String name);
}
