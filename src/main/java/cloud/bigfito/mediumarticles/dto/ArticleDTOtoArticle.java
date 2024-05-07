package cloud.bigfito.mediumarticles.dto;

import cloud.bigfito.mediumarticles.entity.Article;

public class ArticleDTOtoArticle{

    private final Article article;
    private final ArticleDTO articleDTO;

    public ArticleDTOtoArticle(ArticleDTO articleDTO){
        this.articleDTO = articleDTO;
        this.article = new Article();
    }

    public Article getArticleFromArticleDTO(){

        article.setId( Long.parseLong("0") );
        article.setUrl( articleDTO.getUrl() );
        article.setTitle( articleDTO.getTitle() );
        article.setSubtitle( articleDTO.getSubtitle() );
        article.setFirstPara( articleDTO.getFirstPara() );
        article.setImage( articleDTO.getImage() );
        article.setClaps( articleDTO.getClaps() );
        article.setResponses( articleDTO.getResponses() );
        article.setReadingTime( articleDTO.getReadingTime() );
        article.setPublication( articleDTO.getPublication() );
        article.setDate( articleDTO.getDate() );

        return article;
    }

}
