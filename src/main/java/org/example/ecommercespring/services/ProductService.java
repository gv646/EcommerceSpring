package org.example.ecommercespring.services;

import org.example.ecommercespring.dtos.ProductDTO;
import org.example.ecommercespring.dtos.ProductWithCategoryDTO;
import org.example.ecommercespring.entity.Category;
import org.example.ecommercespring.entity.Product;
import org.example.ecommercespring.mappers.ProductMapper;
import org.example.ecommercespring.repository.CategoryRepository;
import org.example.ecommercespring.repository.ProductRepository;
import org.springframework.stereotype.Service;

@Service
public class ProductService implements IProductService {

    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;

    public ProductService(ProductRepository productRepository, CategoryRepository categoryRepository) {
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
    }

    @Override
    public ProductDTO getProductById(Long id) throws Exception {
        return productRepository.findById(id)
                .map(ProductMapper::convertToProductDTO)
                .orElseThrow(() -> new Exception("Product not found"));
    }

    @Override
    public ProductDTO createProduct(ProductDTO productDTO) throws Exception {
        Category category = categoryRepository.findById(productDTO.getCategoryId())
                .orElseThrow(() -> new Exception("Category not found"));
        Product saved = productRepository.save(ProductMapper.convertToProductEntity(productDTO,category));
        return ProductMapper.convertToProductDTO(saved);
    }

    @Override
    public ProductWithCategoryDTO getProductWithCategory(Long id) throws Exception {

        Product product = productRepository.findById(id).orElseThrow(() -> new Exception("Product not found"));

        return ProductMapper.convertToProductWithCategoryDTO(product);
    }
}
