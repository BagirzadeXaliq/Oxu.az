package com.example.oxuaz.model;

import jakarta.validation.constraints.Size;

public class CategoryDTO {
    private Long categoryId;
    @Size(min = 1, max = 255, message = "Name must be between 1 and 255 characters")
    private String name;
}