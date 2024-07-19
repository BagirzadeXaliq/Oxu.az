package com.example.oxuaz.service.impl;

import com.example.oxuaz.dao.entity.CategoryEntity;
import com.example.oxuaz.dao.repository.CategoryRepository;
import com.example.oxuaz.exception.NotFoundException;
import com.example.oxuaz.mapper.CategoryMapper;

import com.example.oxuaz.model.CategoryDTO;
import com.example.oxuaz.service.CategoryService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Slf4j
@Service
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;
    private final CategoryMapper categoryMapper;

    @Override
    public CategoryDTO create(CategoryDTO newCategory) {
        log.info("Creating new category: {}", newCategory);
        CategoryEntity categoryEntity = categoryMapper.mapToEntity(newCategory);
        categoryEntity = categoryRepository.save(categoryEntity);
        CategoryDTO createdCategory = categoryMapper.mapToDTO(categoryEntity);
        log.info("New category created successfully: {}", createdCategory);
        return createdCategory;
    }

    @Override
    public void update(Long categoryId, CategoryDTO updatedCategory) {
        log.info("Updating category with ID: {}", categoryId);
        CategoryEntity existingCategory = categoryRepository.findById(categoryId).orElseThrow(
                () -> new NotFoundException("Category not found with ID: " + categoryId));
        CategoryEntity updatedCategoryEntity = categoryMapper.mapToEntity(updatedCategory);
        updatedCategoryEntity.setCategoryId(existingCategory.getCategoryId());
        categoryRepository.save(updatedCategoryEntity);
        log.info("Category updated successfully with ID: {}", categoryId);
    }

    @Override
    public void delete(Long categoryId) {
        log.info("Deleting category with ID: {}", categoryId);
        categoryRepository.deleteById(categoryId);
        log.info("Category deleted successfully with ID: {}", categoryId);
    }

    @Override
    public CategoryDTO getById(Long categoryId) {
        log.info("Fetch category with ID: {}", categoryId);
        CategoryEntity categoryEntity = categoryRepository.findById(categoryId)
                .orElseThrow(() -> new NotFoundException("Category not found with id: " + categoryId));
        log.debug("Fetched category details: {}", categoryEntity);
        return categoryMapper.mapToDTO(categoryEntity);
    }

    @Override
    public List<CategoryDTO> getAll() {
        log.info("Fetch all categories");
        return categoryRepository.findAll()
                .stream()
                .map(categoryMapper::mapToDTO)
                .collect(Collectors.toList());
    }

}