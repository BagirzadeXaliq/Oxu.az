package com.example.oxuaz.model;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CommentDTO {
    private Long commentId;
    private Long articleId;
    private LocalDateTime createdAt;
    @NotBlank(message = "Content is mandatory")
    private String content;
}