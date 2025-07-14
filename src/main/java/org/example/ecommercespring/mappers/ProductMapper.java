package org.example.ecommercespring.mappers;

import org.example.ecommercespring.dtos.ProductDTO;
import org.example.ecommercespring.dtos.ProductWithCategoryDTO;
import org.example.ecommercespring.entity.Category;
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
                .categoryId(product.getCategory().getId())
                .brand(product.getBrand())
                .popular(product.isPopular())
                .build();
    }

    public static Product convertToProductEntity(ProductDTO productDTO, Category category) {

        return Product.builder()
                .image(productDTO.getImage())
                .color(productDTO.getColor())
                .price(productDTO.getPrice())
                .description(productDTO.getDescription())
                .discount(productDTO.getDiscount())
                .model(productDTO.getModel())
                .title(productDTO.getTitle())
                .category(category)
                .brand(productDTO.getBrand())
                .popular(productDTO.isPopular())
                .build();

    }

    public static ProductWithCategoryDTO convertToProductWithCategoryDTO(Product product) {
        return ProductWithCategoryDTO.builder()
                .id(product.getId())
                .image(product.getImage())
                .color(product.getColor())
                .price(product.getPrice())
                .description(product.getDescription())
                .discount(product.getDiscount())
                .model(product.getModel())
                .title(product.getTitle())
                .brand(product.getBrand())
                .popular(product.isPopular())
                .category(CategoriesMapper.convertToCategoryDTO(product.getCategory()))
                .build();
    }
}
