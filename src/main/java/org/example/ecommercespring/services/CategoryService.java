package org.example.ecommercespring.services;

import org.example.ecommercespring.dtos.AllProductsOfCategoryDTO;
import org.example.ecommercespring.dtos.CategoryDTO;
import org.example.ecommercespring.dtos.ProductDTO;
import org.example.ecommercespring.entity.Category;
import org.example.ecommercespring.mappers.CategoriesMapper;
import org.example.ecommercespring.mappers.ProductMapper;
import org.example.ecommercespring.repository.CategoryRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoryService implements ICategoryService {

    private final CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public List<CategoryDTO> getAllCategories() throws IOException {
        List<CategoryDTO> result = new ArrayList<>();
        List<Category> categories = categoryRepository.findAll();
        for (Category category : categories) {
            result.add(CategoriesMapper.convertToCategoryDTO(category));
        }
        return result;
    }

    @Override
    public CategoryDTO createCategory(CategoryDTO categoryDTO) throws IOException {
        Category saved = categoryRepository.save(CategoriesMapper.convertToCategoryEntity(categoryDTO));
        return CategoriesMapper.convertToCategoryDTO(saved);
    }

    @Override
    public CategoryDTO getByName(String name) throws IOException {
        Category category = categoryRepository.findByName(name).orElseThrow(()-> new IOException("Category not found"));
        return CategoriesMapper.convertToCategoryDTO(category);
    }

    @Override
    public AllProductsOfCategoryDTO getAllProductsOfCategory(Long categoryId) throws IOException {
        Category category = categoryRepository.findById(categoryId).orElseThrow(()-> new IOException("Category not found"));

        List<ProductDTO> productDTOs = category.getProducts().stream().map(ProductMapper::convertToProductDTO).toList();

        return AllProductsOfCategoryDTO.builder()
                .id(categoryId)
                .name(category.getName())
                .products(productDTOs)
                .build();
    }

}
