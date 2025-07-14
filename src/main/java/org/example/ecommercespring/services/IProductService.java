package org.example.ecommercespring.services;

import org.example.ecommercespring.dtos.ProductDTO;
import org.example.ecommercespring.dtos.ProductWithCategoryDTO;

public interface IProductService {

    ProductDTO getProductById(Long id) throws Exception;

    ProductDTO createProduct(ProductDTO productDTO) throws Exception;

    ProductWithCategoryDTO getProductWithCategory(Long id) throws Exception;
}
