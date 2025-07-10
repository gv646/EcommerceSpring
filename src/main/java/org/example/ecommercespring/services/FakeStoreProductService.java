package org.example.ecommercespring.services;

import org.example.ecommercespring.dtos.ProductDTO;
import org.example.ecommercespring.gateway.IProductGateway;
import org.springframework.stereotype.Service;

import java.io.IOException;


public class FakeStoreProductService implements IProductService{

    private final IProductGateway productGateway;

    public FakeStoreProductService(IProductGateway productGateway) {
        this.productGateway = productGateway;
    }
    @Override
    public ProductDTO getProductById(Long id) throws IOException {
        ProductDTO product = productGateway.findById(id);
        return product;
    }

    @Override
    public ProductDTO createProduct(ProductDTO product) throws IOException {
        return null;
    }
}
