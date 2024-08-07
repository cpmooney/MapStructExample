package org.example.nested;

import org.mapstruct.Mapper;

import static org.mapstruct.factory.Mappers.getMapper;

@Mapper(uses = PersonMapper.class)
public interface ArticleMapper {
    ArticleMapper instance = getMapper(ArticleMapper.class);

    ArticleDto articleToArticleDto(Article article);
}
