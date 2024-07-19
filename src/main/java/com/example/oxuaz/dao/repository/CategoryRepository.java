package com.example.oxuaz.dao.repository;

import com.example.oxuaz.dao.entity.CategoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import java.util.List;

public interface CategoryRepository extends JpaRepository<CategoryEntity, Long>, JpaSpecificationExecutor<CategoryEntity> {

    List<CategoryEntity> findByNameContainingIgnoreCase(String name);

}