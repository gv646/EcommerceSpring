package org.example.ecommercespring.gateway;

import org.example.ecommercespring.mappers.GetAllCategoriesMapper;
import org.example.ecommercespring.dtos.CategoryDTO;
import org.example.ecommercespring.dtos.FakeStoreCategoryResponseDTO;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.List;

@Component("fakeStoreRestTemplateGateway")
public class FakeStoreRestTemplateGateway implements ICategoryGateway{

    String baseUrl = "https://fakestoreapi.in/api/products/category";

    @Override
    public List<CategoryDTO> getAllCategories() throws IOException {
        RestTemplate restTemplate = new RestTemplate();

        FakeStoreCategoryResponseDTO fResponse = restTemplate.getForObject(baseUrl, FakeStoreCategoryResponseDTO.class);
        List<CategoryDTO> categories = GetAllCategoriesMapper.toCategoriesDtoList(fResponse);

        return categories;
    }
}
