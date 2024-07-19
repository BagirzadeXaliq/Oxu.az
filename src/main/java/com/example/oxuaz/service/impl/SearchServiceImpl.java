package com.example.oxuaz.service.impl;

import com.example.oxuaz.dao.entity.ArticleEntity;
import com.example.oxuaz.dao.entity.CategoryEntity;
import com.example.oxuaz.dao.entity.CommentEntity;
import com.example.oxuaz.dao.repository.ArticleRepository;
import com.example.oxuaz.dao.repository.CategoryRepository;
import com.example.oxuaz.dao.repository.CommentRepository;
import com.example.oxuaz.mapper.ArticleMapper;
import com.example.oxuaz.mapper.CategoryMapper;
import com.example.oxuaz.mapper.CommentMapper;
import com.example.oxuaz.model.ArticleDTO;
import com.example.oxuaz.model.CategoryDTO;
import com.example.oxuaz.model.CommentDTO;
import com.example.oxuaz.service.SearchService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Slf4j
@Service
public class SearchServiceImpl implements SearchService {

    private final ArticleRepository articleRepository;
    private final CategoryRepository categoryRepository;
    private final CommentRepository commentRepository;
    private final ArticleMapper articleMapper;
    private final CategoryMapper categoryMapper;
    private final CommentMapper commentMapper;

    @Override
    public List<ArticleDTO> searchArticles (String query) {
        log.debug("Searching articles with query: {}", query);
        List<ArticleEntity> articles = articleRepository.findByTitleContainingIgnoreCase(query);
        return articles.stream()
                .map(articleMapper::mapToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<CategoryDTO> searchCategories (String query) {
        log.debug("Searching categories with query: {}", query);
        List<CategoryEntity> categories = categoryRepository.findByNameContainingIgnoreCase(query);
        return categories.stream()
                .map(categoryMapper::mapToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<CommentDTO> searchComments (String query) {
        log.debug("Searching comments with query: {}", query);
        List<CommentEntity> comments = commentRepository.findByContentContainingIgnoreCase(query);
        return comments.stream()
                .map(commentMapper::mapToDTO)
                .collect(Collectors.toList());
    }

}