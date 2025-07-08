package org.example.ecommercespring.gateway.api;

import org.example.ecommercespring.dtos.FakeStoreCategoryResponseDTO;
import org.example.ecommercespring.dtos.FakeStoreProductResponseDTO;
import org.example.ecommercespring.dtos.ProductDTO;
import org.springframework.stereotype.Component;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

import java.io.IOException;

@Component
public interface FakeStoreProductApi {
    @GET("products/{id}")
    Call<FakeStoreProductResponseDTO> getFakeProduct(@Path("id") Long id) throws IOException;
}
