package org.example.ecommercespring.mappers;

import org.example.ecommercespring.dtos.ProductDTO;
import org.example.ecommercespring.entity.Product;

public class ProductMapper {

    public static ProductDTO convertToProductDTO(Product product) {
        return ProductDTO.builder().id(product.getId())
                .image(product.getImage())
                .color(product.getColor())
                .price(product.getPrice())
                .description(product.getDescription())
                .discount(product.getDiscount())
                .model(product.getModel())
                .title(product.getTitle())
                .category(product.getCategory())
                .brand(product.getBrand())
                .popular(product.isPopular())
                .build();
    }

    public static Product convertToProduct(ProductDTO productDTO) {

        return Product.builder()
                .image(productDTO.getImage())
                .color(productDTO.getColor())
                .price(productDTO.getPrice())
                .description(productDTO.getDescription())
                .discount(productDTO.getDiscount())
                .model(productDTO.getModel())
                .title(productDTO.getTitle())
                .category(productDTO.getCategory())
                .brand(productDTO.getBrand())
                .popular(productDTO.isPopular())
                .build();

    }
}
