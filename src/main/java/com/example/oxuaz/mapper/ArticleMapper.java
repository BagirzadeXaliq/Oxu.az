package com.example.oxuaz.mapper;

import com.example.oxuaz.dao.entity.ArticleEntity;
import com.example.oxuaz.model.ArticleDTO;
import org.mapstruct.Mapper;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE, uses = CategoryMapper.class)
public interface ArticleMapper {

    ArticleEntity mapToEntity(ArticleDTO articleDTO);

    ArticleDTO mapToDTO(ArticleEntity articleEntity);

}