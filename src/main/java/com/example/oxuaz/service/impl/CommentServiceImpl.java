package com.example.oxuaz.service.impl;

import com.example.oxuaz.dao.entity.CommentEntity;
import com.example.oxuaz.dao.repository.CommentRepository;
import com.example.oxuaz.exception.NotFoundException;
import com.example.oxuaz.mapper.CommentMapper;
import com.example.oxuaz.model.CommentDTO;
import com.example.oxuaz.service.CommentService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Slf4j
@Service
public class CommentServiceImpl implements CommentService {

    private final CommentRepository commentRepository;
    private final CommentMapper commentMapper;

    @Override
    public CommentDTO create(CommentDTO newComment) {
        log.info("Creating new comment: {}", newComment);
        CommentEntity commentEntity = commentMapper.mapToEntity(newComment);
        commentEntity = commentRepository.save(commentEntity);
        CommentDTO createdComment = commentMapper.mapToDTO(commentEntity);
        log.info("New comment created successfully: {}", createdComment);
        return createdComment;
    }

    @Override
    public void update(Long commentId, CommentDTO updatedComment) {
        log.info("Updating comment with ID: {}", commentId);
        CommentEntity existingComment = commentRepository.findById(commentId).orElseThrow(
                () -> new NotFoundException("Comment not found with ID: " + commentId));
        CommentEntity updatedCommentEntity = commentMapper.mapToEntity(updatedComment);
        updatedCommentEntity.setId(existingComment.getId());
        commentRepository.save(updatedCommentEntity);
        log.info("Comment updated successfully with ID: {}", commentId);
    }

    @Override
    public void delete(Long commentId) {
        log.info("Deleting comment with ID: {}", commentId);
        commentRepository.deleteById(commentId);
        log.info("Comment deleted successfully with ID: {}", commentId);
    }

    @Override
    public CommentDTO getById(Long commentId) {
        log.info("Fetch comment with ID: {}", commentId);
        CommentEntity commentEntity = commentRepository.findById(commentId)
                .orElseThrow(() -> new NotFoundException("Comment not found with id: " + commentId));
        log.debug("Fetched comment details: {}", commentEntity);
        return commentMapper.mapToDTO(commentEntity);
    }

    @Override
    public List<CommentDTO> getByArticleId(Long articleId) {
        return commentRepository.findByArticleId(articleId).stream()
                .map(commentMapper::mapToDTO)
                .collect(Collectors.toList());
    }

}