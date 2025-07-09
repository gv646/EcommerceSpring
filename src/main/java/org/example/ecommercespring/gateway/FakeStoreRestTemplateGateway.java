package org.example.ecommercespring.gateway;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.ecommercespring.adapters.GetAllCategoriesAdapter;
import org.example.ecommercespring.dtos.CategoryDTO;
import org.example.ecommercespring.dtos.FakeStoreCategoryResponseDTO;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Component("fakeStoreRestTemplateGateway")
public class FakeStoreRestTemplateGateway implements ICategoryGateway{

    String baseUrl = "https://fakestoreapi.in/api/products/category";

    @Override
    public List<CategoryDTO> getAllCategories() throws IOException {
        RestTemplate restTemplate = new RestTemplate();

        FakeStoreCategoryResponseDTO fResponse = restTemplate.getForObject(baseUrl, FakeStoreCategoryResponseDTO.class);
        List<CategoryDTO> categories = GetAllCategoriesAdapter.toCategoriesDtoList(fResponse);

        return categories;
    }
}
