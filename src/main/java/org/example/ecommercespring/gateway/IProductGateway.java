package org.example.ecommercespring.gateway;

import org.example.ecommercespring.dtos.ProductDTO;

import java.io.IOException;

public interface IProductGateway {
    ProductDTO findById(Long id) throws IOException;
}
