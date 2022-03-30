package com.example.webprovider.service.impl;

import com.example.webprovider.domain.mapper.CategoryMapper;
import com.example.webprovider.domain.model.Category;
import com.example.webprovider.domain.repository.CategoryRepository;
import com.example.webprovider.service.CategoryService;
import com.example.webprovider.service.dto.CategoryDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;

    @Override
    public CategoryDTO getCategory(String name) {
        Category category = categoryRepository.getCategory(name);
        return CategoryMapper.INSTANCE.categoryToCategoryDTO(category);
    }

    @Override
    public List<CategoryDTO> getAllCategories() {
        return CategoryMapper.INSTANCE.categoriesToCategoriesDTO(categoryRepository.getAllCategories());
    }

    @Override
    public CategoryDTO createCategory(CategoryDTO categoryDTO) {
        log.info(this.getClass().getSimpleName() + " createCategory method");
        Category category = CategoryMapper.INSTANCE.categoryDTOToCategory(categoryDTO);
        category = categoryRepository.createCategory(category);
        return CategoryMapper.INSTANCE.categoryToCategoryDTO(category);
    }

    @Override
    public CategoryDTO updateCategory(Integer id, CategoryDTO categoryDTO) {
        log.info(this.getClass().getSimpleName() + " updateCategory method");
        Category category = CategoryMapper.INSTANCE.categoryDTOToCategory(categoryDTO);
        category = categoryRepository.updateCategory(id, category);
        return CategoryMapper.INSTANCE.categoryToCategoryDTO(category);
    }

    @Override
    public void deleteCategory(Integer id) {
        log.info(this.getClass().getSimpleName() + " deleteCategory method");
        categoryRepository.deleteCategory(id);
    }
}
