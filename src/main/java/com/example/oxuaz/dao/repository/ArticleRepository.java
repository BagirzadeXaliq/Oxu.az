package com.example.oxuaz.dao.repository;

import com.example.oxuaz.dao.entity.ArticleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import java.util.List;

public interface ArticleRepository extends JpaRepository<ArticleEntity, Long>, JpaSpecificationExecutor<ArticleEntity> {

    List<ArticleEntity> findByTitleContainingIgnoreCase(String title);

}