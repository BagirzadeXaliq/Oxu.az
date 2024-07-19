package com.example.oxuaz.controller;

import com.example.oxuaz.model.ArticleDTO;
import com.example.oxuaz.service.ArticleService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/articles")
public class ArticleController {

    private final ArticleService articleService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ArticleDTO create(@Valid @RequestBody ArticleDTO newArticle) {
        return articleService.create(newArticle);
    }

    @PutMapping("/{articleId}")
    @ResponseStatus(HttpStatus.OK)
    public void update(@PathVariable Long articleId, @Valid @RequestBody ArticleDTO updatedArticle) {
        articleService.update(articleId, updatedArticle);
    }

    @DeleteMapping("/{articleId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long articleId) {
        articleService.delete(articleId);
    }

    @GetMapping("/{articleId}")
    @ResponseStatus(HttpStatus.OK)
    public ArticleDTO getById(@PathVariable Long articleId) {
        return articleService.getById(articleId);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<ArticleDTO> getAll() {
        return articleService.getAll();
    }

}