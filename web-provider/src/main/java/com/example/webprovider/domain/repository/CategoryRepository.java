package com.example.webprovider.domain.repository;


import com.example.webprovider.domain.model.Category;

import java.util.List;

public interface CategoryRepository {

    Category getCategory(String name);

    List<Category> getAllCategories();

    Category createCategory(Category category);

    Category updateCategory(Integer id, Category category);

    void deleteCategory(Integer id);
}
