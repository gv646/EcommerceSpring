package org.example.ecommercespring.mappers;

import org.example.ecommercespring.dtos.CategoryDTO;
import org.example.ecommercespring.dtos.FakeStoreCategoryResponseDTO;

import java.util.ArrayList;
import java.util.List;

public class GetAllCategoriesMapper {

    public static List<CategoryDTO> toCategoriesDtoList(FakeStoreCategoryResponseDTO dto) {
        List<CategoryDTO> categories = new ArrayList<>();
//        dto.getCategories().stream().map(CategoryDTO::new).forEach(categories::add);
        return categories;
    }
}
