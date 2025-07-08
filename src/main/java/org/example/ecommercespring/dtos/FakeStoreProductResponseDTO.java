package org.example.ecommercespring.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class FakeStoreProductResponseDTO{
	private ProductDTO product;
	private String message;
	private String status;
}