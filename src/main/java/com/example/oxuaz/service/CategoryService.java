package com.example.oxuaz.service;

import com.example.oxuaz.model.CategoryDTO;
import java.util.List;

public interface CategoryService {

    CategoryDTO create(CategoryDTO newCategory);

    void update(Long categoryId, CategoryDTO updatedCategory);

    void delete(Long categoryId);

    CategoryDTO getById(Long categoryId);

    List<CategoryDTO> getAll();

}