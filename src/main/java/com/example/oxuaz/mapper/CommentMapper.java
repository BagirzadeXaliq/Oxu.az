package com.example.oxuaz.mapper;

import com.example.oxuaz.dao.entity.CommentEntity;
import com.example.oxuaz.model.CommentDTO;
import org.mapstruct.Mapper;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface CommentMapper {

    CommentEntity mapToEntity(CommentDTO commentDTO);

    CommentDTO mapToDTO(CommentEntity commentEntity);

}