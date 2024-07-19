package com.example.oxuaz.controller;

import com.example.oxuaz.model.CategoryDTO;
import com.example.oxuaz.service.CategoryService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/categories")
public class CategoryController {

    private final CategoryService categoryService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CategoryDTO create(@Valid @RequestBody CategoryDTO newCategory) {
        return categoryService.create(newCategory);
    }

    @PutMapping("/{categoryId}")
    @ResponseStatus(HttpStatus.OK)
    public void update(@PathVariable Long categoryId, @Valid @RequestBody CategoryDTO updatedCategory) {
        categoryService.update(categoryId, updatedCategory);
    }

    @DeleteMapping("/{categoryId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long categoryId) {
        categoryService.delete(categoryId);
    }

    @GetMapping("/{categoryId}")
    @ResponseStatus(HttpStatus.OK)
    public CategoryDTO getById(@PathVariable Long categoryId) {
        return categoryService.getById(categoryId);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<CategoryDTO> getAll() {
        return categoryService.getAll();
    }

}