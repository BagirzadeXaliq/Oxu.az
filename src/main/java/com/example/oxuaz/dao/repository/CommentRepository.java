package com.example.oxuaz.dao.repository;

import com.example.oxuaz.dao.entity.CommentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import java.util.List;

public interface CommentRepository extends JpaRepository<CommentEntity, Long>, JpaSpecificationExecutor<CommentEntity> {

    List<CommentEntity> findByArticleId(Long articleId);

    List<CommentEntity> findByContentContainingIgnoreCase(String content);

}