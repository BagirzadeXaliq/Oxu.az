package com.example.oxuaz.service;

import com.example.oxuaz.model.CommentDTO;
import java.util.List;

public interface CommentService {

    CommentDTO create(CommentDTO newComment);

    void update(Long commentId, CommentDTO updatedComment);

    void delete(Long commentId);

    CommentDTO getById(Long commentId);

    List<CommentDTO> getByArticleId(Long articleId);

}