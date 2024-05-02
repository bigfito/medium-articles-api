package cloud.bigfito.mediumarticles.controller;

import cloud.bigfito.mediumarticles.entity.Article;
import cloud.bigfito.mediumarticles.exception.custom.BadArgumentException;
import cloud.bigfito.mediumarticles.service.implementation.ArticleServiceImplementation;
import jakarta.validation.Valid;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.CannotCreateTransactionException;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequestMapping("/medium/api/v1")
@RestController
public class ArticleController {

    ArticleServiceImplementation articleServiceImplementation;

    public ArticleController(ArticleServiceImplementation articleServiceImplementation) {
        this.articleServiceImplementation = articleServiceImplementation;
    }

    @GetMapping("/articles")
    public ResponseEntity<?> selectAllArticles(@RequestParam(defaultValue = "0") String page) {

        HttpHeaders responseHeaders = new HttpHeaders();

        try {
                Integer articlePage = Integer.parseInt(page);

            if ( articlePage >= 0 ){

                List<Article> currentPage = articleServiceImplementation.getAllArticlesFromDB(articlePage);

                if ( currentPage.isEmpty() ){
                    responseHeaders.add("Status", "EMPTY");
                    return new ResponseEntity<>("There are no articles to show at this moment.", responseHeaders, HttpStatus.OK);
                }else{
                    responseHeaders.add("Status", "OK");
                    return new ResponseEntity<>(currentPage, responseHeaders, HttpStatus.OK);
                }

            }else{

                throw new BadArgumentException("The {page} parameter must be a positive number of type LONG.");
            }

        }catch (NumberFormatException e1) {
            responseHeaders.add("Status", "ERROR");
            return new ResponseEntity<>("The {page} parameter must be a positive number of type INTEGER.", responseHeaders, HttpStatus.BAD_REQUEST);
        }catch (CannotCreateTransactionException e2){
            responseHeaders.add("Status", "ERROR");
            return new ResponseEntity<>("The API is not AVAILABLE at this moment.", responseHeaders, HttpStatus.SERVICE_UNAVAILABLE);
        }

    }

    @GetMapping("/articles/{id}")
    public ResponseEntity<?> selectArticleById(@PathVariable(value = "id", required = true) String id) {

        HttpHeaders responseHeaders = new HttpHeaders();

        try {

            Long articleId = Long.parseLong(id);

            if ( articleId > 0 ){

                Optional<Article> article = articleServiceImplementation.getArticleFromDB(articleId);

                if ( articleServiceImplementation.getArticleFromDB(articleId).isPresent() ) {
                    responseHeaders.add("Status", "FOUND");
                    return new ResponseEntity<>(article, responseHeaders, HttpStatus.OK);
                }else{
                    responseHeaders.add("Status", "NOT_FOUND");
                    return new ResponseEntity<>("There is no article for the given ID.", responseHeaders, HttpStatus.NOT_FOUND);
                }

            }else{
                throw new BadArgumentException("The {id} parameter must be a positive number of type LONG.");
            }

        }catch (NumberFormatException e1) {
            responseHeaders.add("Status", "ERROR");
            return new ResponseEntity<>("The {id} parameter must be a positive number of type LONG.", responseHeaders, HttpStatus.BAD_REQUEST);
        }catch (CannotCreateTransactionException e2){
            responseHeaders.add("Status", "ERROR");
            return new ResponseEntity<>("The API is not AVAILABLE at this moment.", responseHeaders, HttpStatus.SERVICE_UNAVAILABLE);
        }

    }

    @PutMapping("/articles")
    public ResponseEntity<?> updateArticle(@Valid @RequestBody Article article) {

        HttpHeaders responseHeaders = new HttpHeaders();

        try {
            if ( articleServiceImplementation.updateArticleInDB(article) ) {
                responseHeaders.add("Status", "UPDATED");
                return new ResponseEntity<>(article, responseHeaders, HttpStatus.OK);
            }else{
                responseHeaders.add("Status", "NOT_FOUND");
                return new ResponseEntity<>(article, responseHeaders, HttpStatus.NOT_FOUND);
            }
        }catch (CannotCreateTransactionException e1){
            responseHeaders.add("Status", "ERROR");
            return new ResponseEntity<>("The API is not AVAILABLE at this moment.", responseHeaders, HttpStatus.SERVICE_UNAVAILABLE);
        }catch (Exception e2){
            responseHeaders.add("Status", "ERROR");
            return new ResponseEntity<>("Check parameters in the BODY REQUEST.", responseHeaders, HttpStatus.BAD_REQUEST);
        }

    }

    @DeleteMapping("/articles/{id}")
    public ResponseEntity<?> deleteArticle(@PathVariable(value = "id", required = true) String id) {

        HttpHeaders responseHeaders = new HttpHeaders();

        try {
            Long articleId = Long.parseLong(id);

            if ( articleId > 0 ){

                if ( articleServiceImplementation.removeArticleFromDB(articleId) ) {
                    responseHeaders.add("Status", "DELETED");
                    return new ResponseEntity<>(null, responseHeaders, HttpStatus.OK);
                }else{
                    responseHeaders.add("Status", "NOT_FOUND");
                    return new ResponseEntity<>("There is no article for the given ID.", responseHeaders, HttpStatus.NOT_FOUND);
                }

            }else{
                throw new BadArgumentException("The {id} parameter must be a positive number of type LONG.");
            }

        }catch (NumberFormatException e1) {
            responseHeaders.add("Status", "ERROR");
            return new ResponseEntity<>("The {id} parameter must be a positive number of type LONG.", responseHeaders, HttpStatus.BAD_REQUEST);
        }catch (CannotCreateTransactionException e2){
            responseHeaders.add("Status", "ERROR");
            return new ResponseEntity<>("The API is not AVAILABLE at this moment.", responseHeaders, HttpStatus.SERVICE_UNAVAILABLE);
        }
    }

}