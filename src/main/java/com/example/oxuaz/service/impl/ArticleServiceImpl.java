package com.example.oxuaz.service.impl;

import com.example.oxuaz.dao.entity.ArticleEntity;
import com.example.oxuaz.dao.repository.ArticleRepository;
import com.example.oxuaz.exception.NotFoundException;
import com.example.oxuaz.mapper.ArticleMapper;
import com.example.oxuaz.model.ArticleDTO;
import com.example.oxuaz.service.ArticleService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Slf4j
@Service
public class ArticleServiceImpl implements ArticleService {

    private final ArticleRepository articleRepository;
    private final ArticleMapper articleMapper;

    @Override
    public ArticleDTO create(ArticleDTO newArticle) {
        log.info("Creating new article: {}", newArticle);
        ArticleEntity articleEntity = articleMapper.mapToEntity(newArticle);
        articleEntity = articleRepository.save(articleEntity);
        ArticleDTO createdArticle = articleMapper.mapToDTO(articleEntity);
        log.info("New article created successfully: {}", createdArticle);
        return createdArticle;
    }

    @Override
    public void update(Long articleId, ArticleDTO updatedArticle) {
        log.info("Updating article with ID: {}", articleId);
        ArticleEntity existingArticle = articleRepository.findById(articleId).orElseThrow(
                () -> new NotFoundException("Article not found with ID: " + articleId));
        ArticleEntity updatedArticleEntity = articleMapper.mapToEntity(updatedArticle);
        updatedArticleEntity.setId(existingArticle.getId());
        articleRepository.save(updatedArticleEntity);
        log.info("Article updated successfully with ID: {}", articleId);
    }

    @Override
    public void delete(Long articleId) {
        log.info("Deleting article with ID: {}", articleId);
        articleRepository.deleteById(articleId);
        log.info("Article deleted successfully with ID: {}", articleId);
    }

    @Override
    public ArticleDTO getById(Long articleId) {
        log.info("Fetch article with ID: {}", articleId);
        ArticleEntity articleEntity = articleRepository.findById(articleId)
                .orElseThrow(() -> new NotFoundException("Article not found with id: " + articleId));
        log.debug("Fetched article details: {}", articleEntity);
        return articleMapper.mapToDTO(articleEntity);
    }

    @Override
    public List<ArticleDTO> getAll() {
        log.info("Fetch all articles");
        return articleRepository.findAll()
                .stream()
                .map(articleMapper::mapToDTO)
                .collect(Collectors.toList());
    }

}