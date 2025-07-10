package org.example.ecommercespring.services;

import org.example.ecommercespring.dtos.ProductDTO;
import org.example.ecommercespring.entity.Product;
import org.example.ecommercespring.mappers.ProductMapper;
import org.example.ecommercespring.repository.ProductRepository;
import org.springframework.stereotype.Service;

@Service
public class ProductService implements IProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public ProductDTO getProductById(Long id) throws Exception {
        return productRepository.findById(id)
                .map(ProductMapper::convertToProductDTO)
                .orElseThrow(() -> new Exception("Product not found"));
    }

    @Override
    public ProductDTO createProduct(ProductDTO productDTO) throws Exception {
        Product saved = productRepository.save(ProductMapper.convertToProduct(productDTO));
        return ProductMapper.convertToProductDTO(saved);
    }
}
