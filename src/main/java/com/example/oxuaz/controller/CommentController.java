package com.example.oxuaz.controller;

import com.example.oxuaz.model.CommentDTO;
import com.example.oxuaz.service.CommentService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/comments")
public class CommentController {

    private final CommentService commentService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CommentDTO create(@Valid @RequestBody CommentDTO newComment) {
        return commentService.create(newComment);
    }

    @PutMapping("/{commentId}")
    @ResponseStatus(HttpStatus.OK)
    public void update(@PathVariable Long commentId, @Valid @RequestBody CommentDTO updatedComment) {
        commentService.update(commentId, updatedComment);
    }

    @DeleteMapping("/{commentId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long commentId) {
        commentService.delete(commentId);
    }

    @GetMapping("/{commentId}")
    @ResponseStatus(HttpStatus.OK)
    public CommentDTO getById(@PathVariable Long commentId) {
        return commentService.getById(commentId);
    }

    @GetMapping("/article/{articleId}")
    @ResponseStatus(HttpStatus.OK)
    public List<CommentDTO> getByArticleId(@PathVariable Long articleId) {
        return commentService.getByArticleId(articleId);
    }

}