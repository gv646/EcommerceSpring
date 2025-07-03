package org.example.ecommercespring.services;

import org.example.ecommercespring.dtos.CategoryDTO;

import java.io.IOException;
import java.util.List;

public interface ICategoryService {

    public List<CategoryDTO> getAllCategories() throws IOException;

}
