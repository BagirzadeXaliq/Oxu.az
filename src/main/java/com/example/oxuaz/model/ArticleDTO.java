package com.example.oxuaz.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ArticleDTO {
    private Long articleId;
    @NotBlank(message = "Title is mandatory")
    @Size(max = 255, message = "Title cannot exceed 255 characters")
    private String title;
    @NotBlank(message = "Content is mandatory")
    @Size(max = 1000, message = "Content cannot exceed 1000 characters")
    private String content;
    @NotNull(message = "Published date is mandatory")
    private LocalDateTime publishedDate;
    private CategoryDTO category;
    private List<CommentDTO> comments;
}