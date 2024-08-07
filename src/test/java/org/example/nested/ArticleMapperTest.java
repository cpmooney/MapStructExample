package org.example.nested;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class ArticleMapperTest {

    @Test
    void articleToArticleDto() {
        Article article = new Article();
        article.id = 7;
        article.name = "DK the Dude";
        article.author = new PersonDto();
        article.author.id = "dude123";
        article.author.name = "Benjamin";

        ArticleDto articleDto = ArticleMapper.instance.articleToArticleDto(article);

        assertThat(articleDto.author.id).isEqualTo("dude123");
    }
}