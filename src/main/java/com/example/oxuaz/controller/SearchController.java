package com.example.oxuaz.controller;

import com.example.oxuaz.model.ArticleDTO;
import com.example.oxuaz.model.CategoryDTO;
import com.example.oxuaz.model.CommentDTO;
import com.example.oxuaz.service.SearchService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/search")
public class SearchController {

    private final SearchService searchService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<ArticleDTO> searchArticles(@RequestParam String query) {
        return searchService.searchArticles(query);
    }

    @GetMapping("/categories")
    @ResponseStatus(HttpStatus.OK)
    public List<CategoryDTO> searchCategories(@RequestParam String query) {
        return searchService.searchCategories(query);
    }

    @GetMapping("/comments")
    @ResponseStatus(HttpStatus.OK)
    public List<CommentDTO> searchComments(@RequestParam String query) {
        return searchService.searchComments(query);
    }

}