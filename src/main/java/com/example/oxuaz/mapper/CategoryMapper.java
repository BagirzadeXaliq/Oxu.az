package com.example.oxuaz.mapper;

import com.example.oxuaz.dao.entity.CategoryEntity;
import com.example.oxuaz.model.CategoryDTO;
import org.mapstruct.Mapper;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface CategoryMapper {

    CategoryEntity mapToEntity(CategoryDTO categoryDTO);

    CategoryDTO mapToDTO(CategoryEntity categoryEntity);

}