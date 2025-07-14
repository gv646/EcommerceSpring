package org.example.ecommercespring.mappers;

import org.example.ecommercespring.dtos.CategoryDTO;
import org.example.ecommercespring.entity.Category;

public class CategoriesMapper {

    public static CategoryDTO convertToCategoryDTO(Category category) {
        return CategoryDTO.builder()
                .id(category.getId())
                .name(category.getName())
                .build();
    }

    public static Category convertToCategoryEntity(CategoryDTO categoryDTO) {
        return Category.builder()
                .name(categoryDTO.getName())
                .build();
    }
}
