package org.example.ecommercespring.services;

import org.example.ecommercespring.dtos.AllProductsOfCategoryDTO;
import org.example.ecommercespring.dtos.CategoryDTO;

import java.io.IOException;
import java.util.List;

public interface ICategoryService {

    public List<CategoryDTO> getAllCategories() throws IOException;

    public CategoryDTO createCategory(CategoryDTO categoryDTO) throws IOException;

    public CategoryDTO getByName(String name) throws IOException;

    public AllProductsOfCategoryDTO getAllProductsOfCategory(Long categoryId) throws IOException;

}
