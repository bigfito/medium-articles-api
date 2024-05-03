package cloud.bigfito.mediumarticles.redis;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/medium/api/v1/articles")
public class RedisCacheController {

    private final RedisCacheServiceImplementation redisCacheServiceImplementation;

    public RedisCacheController(RedisCacheServiceImplementation redisCacheServiceImplementation){
        this.redisCacheServiceImplementation = redisCacheServiceImplementation;
    }

    @GetMapping("/clearcache")
    public ResponseEntity<String> clearRedisCache(){

        redisCacheServiceImplementation.clearRedisCacheForArticles();
        redisCacheServiceImplementation.clearRedisCacheForArticle();
        return new ResponseEntity<String>("REDIS CACHE cleared.", HttpStatus.OK);

    }

}
