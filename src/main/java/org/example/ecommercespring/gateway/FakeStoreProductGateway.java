package org.example.ecommercespring.gateway;

import org.example.ecommercespring.dtos.FakeStoreProductResponseDTO;
import org.example.ecommercespring.dtos.ProductDTO;
import org.example.ecommercespring.gateway.api.FakeStoreProductApi;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class FakeStoreProductGateway implements IProductGateway{

    private final FakeStoreProductApi fakeStoreProductApi;

    public FakeStoreProductGateway(FakeStoreProductApi fakeStoreProductApi) {
        this.fakeStoreProductApi = fakeStoreProductApi;
    }
    @Override
    public ProductDTO findById(Long id) throws IOException {
        FakeStoreProductResponseDTO response = fakeStoreProductApi.getFakeProduct(id).execute().body();
        if (response == null) {
            throw new IOException("Product not found");
        }
        return response.getProduct();
    }
}
