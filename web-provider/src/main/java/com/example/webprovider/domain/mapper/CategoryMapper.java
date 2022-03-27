package com.example.webprovider.domain.mapper;


import com.example.webprovider.domain.model.Category;
import com.example.webprovider.service.dto.CategoryDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface CategoryMapper {

    CategoryMapper INSTANCE = Mappers.getMapper(CategoryMapper.class);

    CategoryDTO categoryToCategoryDTO(Category category);

    Category categoryDTOToCategory(CategoryDTO categoryDTO);

    List<CategoryDTO> categoriesToCategoriesDTO(List<Category> categories);
}
