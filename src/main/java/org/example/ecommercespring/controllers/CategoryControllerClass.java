package org.example.ecommercespring.controllers;

import org.example.ecommercespring.dtos.CategoryDTO;
import org.example.ecommercespring.services.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("api/categories")
public class CategoryControllerClass {

    private final ICategoryService categoryService;

    public CategoryControllerClass(ICategoryService _categoryService) {
        this.categoryService = _categoryService;
    }

    @GetMapping
    public List<CategoryDTO> getAllCategories() throws IOException {
        return categoryService.getAllCategories();
    }

    @GetMapping("/count")
    public int getCount(){
        return 1;
    }

}
