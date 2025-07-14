package org.example.ecommercespring.dtos;

import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AllProductsOfCategoryDTO {
    private Long id;
    private String name;
    private List<ProductDTO> products;
}
