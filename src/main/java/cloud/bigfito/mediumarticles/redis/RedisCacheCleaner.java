package cloud.bigfito.mediumarticles.redis;

import lombok.extern.log4j.Log4j2;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

@Component
@EnableScheduling
@Log4j2
public class RedisCacheCleaner {

    private final CacheManager cacheManager;

    public RedisCacheCleaner(CacheManager cacheManager){
        this.cacheManager = cacheManager;
    }

    @Scheduled(fixedDelay = 1, timeUnit = TimeUnit.HOURS)
    @CacheEvict(value = "article-single")
    public void clearCacheForArticle(){
        Objects.requireNonNull(cacheManager.getCache("article-single")).clear();
        log.info("Redis Cache article-single cleared at: " + LocalDateTime.now());
    }

    @Scheduled(fixedDelay = 1, timeUnit = TimeUnit.HOURS)
    @CacheEvict("article-list")
    public void clearCacheForAllArticles(){
        Objects.requireNonNull(cacheManager.getCache("article-list")).clear();
        log.info("Redis Cache article-list cleared at: " + LocalDateTime.now());
    }

}
