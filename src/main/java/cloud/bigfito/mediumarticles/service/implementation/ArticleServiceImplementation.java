package cloud.bigfito.mediumarticles.service.implementation;

import cloud.bigfito.mediumarticles.dto.ArticleDTO;
import cloud.bigfito.mediumarticles.entity.Article;
import cloud.bigfito.mediumarticles.repository.ArticleRepository;
import cloud.bigfito.mediumarticles.service.ArticleService;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class ArticleServiceImplementation implements ArticleService {

    private final ArticleRepository articleRepository;

    public ArticleServiceImplementation(ArticleRepository articleRepository) {
        this.articleRepository = articleRepository;
    }

    @Transactional
    @Override
    public Article saveArticleInDB(ArticleDTO articleDTO) {

        Optional<Article> articleInDatabase =  articleRepository.findByUrl( articleDTO.getUrl() );

        Article articleToSave = new Article();
        articleToSave.setUrl( articleDTO.getUrl() );
        articleToSave.setTitle( articleDTO.getTitle() );
        articleToSave.setSubtitle( articleDTO.getSubtitle() );
        articleToSave.setFirstPara( articleDTO.getFirstPara() );
        articleToSave.setImage( articleDTO.getImage() );
        articleToSave.setClaps( articleDTO.getClaps() );
        articleToSave.setResponses( articleDTO.getResponses() );
        articleToSave.setReadingTime( articleDTO.getReadingTime() );
        articleToSave.setPublication( articleDTO.getPublication() );
        articleToSave.setDate( articleDTO.getDate() );

        if ( articleInDatabase.isPresent() ) {

            return articleToSave;

        }else{

            return articleRepository.save( articleToSave );

        }

    }

    @Cacheable(value = "article-list")
    public List<Article> getAllArticlesFromDB(Integer page) {

        Sort articlesSort = Sort.by(Sort.Direction.ASC, "id");
        Pageable defaultPage = PageRequest.of(page, 25, articlesSort);
        return articleRepository.findAll(defaultPage).toList();

    }

    @Cacheable(value = "article-single")
    public Optional<Article> getArticleFromDB(Long id) {

        return articleRepository.findById(id);
    }

    @Transactional
    public Boolean updateArticleInDB(Article article) {

        Optional<Article> articleInDatabase = articleRepository.findById(article.getId());

        if (articleInDatabase.isPresent()) {
            articleRepository.save(article);
            return true;
        }else{
            return false;
        }
    }

    @Transactional
    @CacheEvict(value = "article-single", key = "#id")
    public Boolean removeArticleFromDB(Long id) {

        Optional<Article> articleInDatabase = articleRepository.findById(id);

        if (articleInDatabase.isPresent()) {
            articleRepository.deleteById(id);
            return true;
        }else{
            return false;
        }
    }
}