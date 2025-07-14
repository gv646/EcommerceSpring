package org.example.ecommercespring.controllers;

import org.example.ecommercespring.dtos.CategoryDTO;
import org.example.ecommercespring.services.CategoryService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {

    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping
    public ResponseEntity<?> getAllCategories(@RequestParam(required = false) String name) throws IOException {
        if(name != null && !name.isBlank()) {
            System.out.println("***** yes in if block *****");
            CategoryDTO categoryDTO = categoryService.getByName(name);
            return ResponseEntity.ok(categoryDTO);
        }else{
            System.out.println("***** yes in else block *****");
            List<CategoryDTO> result = categoryService.getAllCategories();
            return ResponseEntity.ok(result);
        }
    }

    @PostMapping
    public ResponseEntity<CategoryDTO> createCategory(@RequestBody CategoryDTO categoryDto) throws IOException {
        return ResponseEntity.ok().body(categoryService.createCategory(categoryDto));
    }
}
