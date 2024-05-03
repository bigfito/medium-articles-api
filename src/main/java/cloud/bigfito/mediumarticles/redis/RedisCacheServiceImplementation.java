package cloud.bigfito.mediumarticles.redis;

import lombok.extern.log4j.Log4j2;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Objects;

@Service
@Log4j2
public class RedisCacheServiceImplementation {

    private final CacheManager cacheManager;

    public RedisCacheServiceImplementation(CacheManager cacheManager) {

        this.cacheManager = cacheManager;
    }

    @CacheEvict("article-list")
    public void clearRedisCacheForArticles(){
        Objects.requireNonNull(cacheManager.getCache("article-list")).clear();
        log.info("Redis Cache article-list cleared manually at: " + LocalDateTime.now());
    }

    @CacheEvict("article-single")
    public void clearRedisCacheForArticle(){
        Objects.requireNonNull(cacheManager.getCache("article-single")).clear();
        log.info("Redis Cache article-single cleared manually at: " + LocalDateTime.now());
    }
}
