package com.cruzroja.carbon_foot_print.Infrastucture.Output.Persistence.Repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.cruzroja.carbon_foot_print.Infrastucture.Output.Persistence.Entities.CategoryEntity;

public interface CategoryRepository extends CrudRepository<CategoryEntity, Long> {

    boolean existsByCategoryNameLike(String categoryName);

    List<CategoryEntity> findByCategoryNameLike(String categoryName);

}
