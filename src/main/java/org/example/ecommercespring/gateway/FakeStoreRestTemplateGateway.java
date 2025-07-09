package org.example.ecommercespring.gateway;

import org.example.ecommercespring.dtos.CategoryDTO;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.List;

@Component("fakeStoreRestTemplateGateway")
public class FakeStoreRestTemplateGateway implements ICategoryGateway{
    @Override
    public List<CategoryDTO> getAllCategories() throws IOException {
        return List.of();
    }
}
