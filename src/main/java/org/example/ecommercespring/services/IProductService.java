package org.example.ecommercespring.services;

import org.example.ecommercespring.dtos.ProductDTO;

public interface IProductService {

    ProductDTO getProductById(Long id) throws Exception;
}
