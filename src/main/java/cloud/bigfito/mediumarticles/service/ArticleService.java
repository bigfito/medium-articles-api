package cloud.bigfito.mediumarticles.service;

import cloud.bigfito.mediumarticles.dto.ArticleDTO;
import cloud.bigfito.mediumarticles.entity.Article;

import java.util.List;
import java.util.Optional;

public interface ArticleService {

    Article saveArticleInDB(ArticleDTO articleDTO);
    List<Article> getAllArticlesFromDB(Integer page);
    Optional<Article> getArticleFromDB(Long id);
    Boolean updateArticleInDB(Article article);
    Boolean removeArticleFromDB(Long id);

}