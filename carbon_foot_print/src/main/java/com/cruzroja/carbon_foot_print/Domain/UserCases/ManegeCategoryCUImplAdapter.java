package com.cruzroja.carbon_foot_print.Domain.UserCases;

import java.util.List;

import com.cruzroja.carbon_foot_print.Application.Input.ManegeCategoryCUIntPort;
import com.cruzroja.carbon_foot_print.Application.Output.ExceptionFormatterIntPort;
import com.cruzroja.carbon_foot_print.Application.Output.ManegeCategoryGatewayIntPort;
import com.cruzroja.carbon_foot_print.Domain.Models.Category;

public class ManegeCategoryCUImplAdapter implements ManegeCategoryCUIntPort {

    private final ManegeCategoryGatewayIntPort gateway;
    private final ExceptionFormatterIntPort errorFormatter;

    public ManegeCategoryCUImplAdapter(ManegeCategoryGatewayIntPort gateway, ExceptionFormatterIntPort errorFormatter) {
        this.gateway = gateway;
        this.errorFormatter = errorFormatter;
    }

    @Override
    public Category create(Category category) {
        if (!category.isValidScope(category.getCategoryScope()))
            this.errorFormatter.returnResponseBusinessRuleViolated(
                    "The value of scope can only be \"Alcance 1\", \"Alcance 2\" o \"Alcance 3\"");
        if (!category.isValidPollution(this.gateway.findAllPollutionTypes()))
            this.errorFormatter.returnResponseBusinessRuleViolated(
                    "The contamination types entered have not been recorded in the system.");
        if (this.gateway.existsByName(category.getCategoryName()))
            this.errorFormatter.returnResponseErrorEntityExists(
                    "All ready exists a category with Category Name: " + category.getCategoryName() + ".");
        category.determineStatus();
        return this.gateway.create(category);
    }

    @Override
    public Category update(Category category) {
        if (!category.isValidScope(category.getCategoryScope()))
            this.errorFormatter.returnResponseBusinessRuleViolated(
                    "The value of scope can only be \"Alcance 1\", \"Alcance 2\" o \"Alcance 3\"");
        Category old = this.gateway.findById(category.getCategoryId());
        if (!category.isValidPollution(this.gateway.findAllPollutionTypes()))
            this.errorFormatter.returnResponseBusinessRuleViolated(
                    "The contamination types entered have not been recorded in the system.");
        if (old.isUpdateName(category.getCategoryName()))
            if (this.gateway.existsByName(category.getCategoryName()))
                this.errorFormatter.returnResponseErrorEntityExists(
                        "All ready exists a category with Category Name: " + category.getCategoryName() + ".");
        old.update(category);
        return this.gateway.update(old);
    }

    @Override
    public Category findById(long id) {
        if (!this.gateway.existsById(id))
            this.errorFormatter.returNoData("A category with id " + id + "has not been registered");
        return this.gateway.findById(id);
    }

    @Override
    public List<Category> findAll() {
        List<Category> categories = this.gateway.findAll();
        if (categories.isEmpty())
            this.errorFormatter.returNoData("No categories have been registered");
        return categories;
    }

    @Override
    public List<Category> findByName(String name) {

        List<Category> categories = this.gateway.findByName(name);
        if (categories.isEmpty())
            this.errorFormatter.returNoData("No categories have been registered with the name " + name + ".");
        return categories;
    }

}
