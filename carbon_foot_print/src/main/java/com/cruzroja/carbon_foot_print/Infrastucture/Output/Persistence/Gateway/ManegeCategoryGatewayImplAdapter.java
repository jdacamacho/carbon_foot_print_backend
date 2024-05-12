package com.cruzroja.carbon_foot_print.Infrastucture.Output.Persistence.Gateway;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.stereotype.Service;

import com.cruzroja.carbon_foot_print.Application.Output.ManegeCategoryGatewayIntPort;
import com.cruzroja.carbon_foot_print.Domain.Models.Category;
import com.cruzroja.carbon_foot_print.Domain.Models.PollutionType;
import com.cruzroja.carbon_foot_print.Infrastucture.Output.Persistence.Entities.CategoryEntity;
import com.cruzroja.carbon_foot_print.Infrastucture.Output.Persistence.Entities.PollutionTypeEntity;
import com.cruzroja.carbon_foot_print.Infrastucture.Output.Persistence.Repositories.CategoryRepository;

@Service
public class ManegeCategoryGatewayImplAdapter implements ManegeCategoryGatewayIntPort {

    private final CategoryRepository serviceBD;
    private final ModelMapper mapper;

    public ManegeCategoryGatewayImplAdapter(CategoryRepository serviceBD, ModelMapper mapper) {
        this.serviceBD = serviceBD;
        this.mapper = mapper;
    }

    @Override
    public Category create(Category category) {
        CategoryEntity categoryToSave = this.mapper.map(category, CategoryEntity.class);
        CategoryEntity categorySaved = this.serviceBD.save(categoryToSave);
        return this.mapper.map(categorySaved, Category.class);
    }

    @Override
    public Category update(Category category) {
        CategoryEntity categoryToUpdate = this.mapper.map(category, CategoryEntity.class);
        CategoryEntity categoryUpdated = this.serviceBD.save(categoryToUpdate);
        return this.mapper.map(categoryUpdated, Category.class);
    }

    @Override
    public Category findById(long id) {
        CategoryEntity dataFromBD = this.serviceBD.findById(id).get();
        Category response = this.mapper.map(dataFromBD, Category.class);
        return response;
    }

    @Override
    public List<Category> findAll() {
        Iterable<CategoryEntity> dataFromBD = this.serviceBD.findAll();
        return this.mapper.map(dataFromBD, new TypeToken<List<Category>>() {
        }.getType());
    }

    @Override
    public List<Category> findByName(String name) {
        Iterable<CategoryEntity> dataFromBD = this.serviceBD.findByCategoryNameLike("%" + name + "%");
        return this.mapper.map(dataFromBD, new TypeToken<List<Category>>() {
        }.getType());
    }

    @Override
    public List<PollutionType> findAllPollutionTypes() {
        Iterable<PollutionTypeEntity> dataFromBD = this.serviceBD.findAllPollutionTypes();
        return this.mapper.map(dataFromBD, new TypeToken<List<PollutionType>>() {
        }.getType());
    }

    @Override
    public boolean existsById(long id) {
        return this.serviceBD.existsById(id);
    }

    @Override
    public boolean existsByName(String name) {
        return this.serviceBD.existsByCategoryNameLike("%" + name + "%");
    }

    @Override
    public List<Category> getAllEnable() {
        Iterable<CategoryEntity> dataFromBD = this.serviceBD.findByCategoryStateIsTrue();
        return this.mapper.map(dataFromBD, new TypeToken<List<Category>>() {
        }.getType());
    }

    @Override
    public List<Category> getMoreById(List<Long> ids) {
        Iterable<CategoryEntity> dataFromBD = this.serviceBD.findByCategoryIdIn(ids);
        return this.mapper.map(dataFromBD, new TypeToken<List<Category>>() {
        }.getType());
    }

    @Override
    public List<Category> getMoreEnableById(List<Long> ids) {
        Iterable<CategoryEntity> dataFromBD = this.serviceBD.findByCategoryStateIsTrueAndCategoryIdIn(ids);
        return this.mapper.map(dataFromBD, new TypeToken<List<Category>>() {
        }.getType());
    }

}
