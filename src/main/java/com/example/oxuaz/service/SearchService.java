package com.example.oxuaz.service;

import com.example.oxuaz.model.ArticleDTO;
import com.example.oxuaz.model.CategoryDTO;
import com.example.oxuaz.model.CommentDTO;
import java.util.List;

public interface SearchService {

    List<ArticleDTO> searchArticles (String query);

    List<CategoryDTO> searchCategories (String query);

    List<CommentDTO> searchComments (String query);

}