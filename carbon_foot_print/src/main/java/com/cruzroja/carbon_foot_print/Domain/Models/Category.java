package com.cruzroja.carbon_foot_print.Domain.Models;

import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Category {
    private long categoryId;
    private String categoryName;
    private String categoryDescription;
    private String categoryScope;

    public void update(Category newCategory) {
        this.categoryName = newCategory.categoryName;
        this.categoryDescription = newCategory.categoryDescription;
        this.categoryScope = newCategory.categoryScope;
    }

    public boolean isValidScope(String newScope) {
        List<String> scopes = new ArrayList<String>();
        scopes.add("Alcance 1");
        scopes.add("Alcance 2");
        scopes.add("Alcance 3");

        boolean flag = false;
        for (String scope : scopes) {
            flag = scope.equals(newScope);
            if (flag)
                break;
        }
        return flag;
    }

    public boolean isUpdateName(String name) {
        return !this.categoryName.equals(name);
    }

    public Category() {
    }
}
