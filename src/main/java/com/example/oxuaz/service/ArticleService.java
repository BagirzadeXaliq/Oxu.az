package com.example.oxuaz.service;

import com.example.oxuaz.model.ArticleDTO;
import java.util.List;

public interface ArticleService {

    ArticleDTO create(ArticleDTO newArticle);

    void update(Long articleId, ArticleDTO updatedArticle);

    void delete(Long articleId);

    ArticleDTO getById(Long articleId);

    List<ArticleDTO> getAll();

}