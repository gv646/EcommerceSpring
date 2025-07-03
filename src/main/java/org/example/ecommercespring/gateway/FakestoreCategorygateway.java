package org.example.ecommercespring.gateway;

import org.example.ecommercespring.dtos.CategoryDTO;
import org.example.ecommercespring.dtos.FakeStoreCategoryResponseDTO;
import org.example.ecommercespring.gateway.api.FakeStoreCategoryApi;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.List;

@Component
public class FakestoreCategorygateway implements ICategoryGateway {

    private final FakeStoreCategoryApi fakeStoreCategoryApi;

    public FakestoreCategorygateway(FakeStoreCategoryApi fakeStoreCategoryApi) {
        this.fakeStoreCategoryApi = fakeStoreCategoryApi;
    }

    @Override
    public List<CategoryDTO> getAllCategories() throws IOException {

        FakeStoreCategoryResponseDTO response = fakeStoreCategoryApi.getAllFakeCategories().execute().body();
        if(response==null){
            throw new IOException("No categories found");
        }
        return response.getCategories().stream().map(category -> CategoryDTO.builder().name(category).build()).toList();
    }
}
