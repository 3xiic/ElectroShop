package co.edu.unbosque.ElectroShop.config;

import com.github.benmanes.caffeine.cache.Caffeine;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.caffeine.CaffeineCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.TimeUnit;

@Configuration
@EnableCaching
public class CacheConfig {

    /**
     * Returns a {@link CaffeineCacheManager} that is used to manage named
     * caches. The manager is configured with three caches: "productCache",
     * "detailCache", and "clientCache". The caches are configured by the
     * {@link #caffeineCacheBuilder()} method.
     *
     * @return a cache manager
     */
    @Bean
    public CaffeineCacheManager cacheManager() {
        CaffeineCacheManager cacheManager = new CaffeineCacheManager("productCache", "detailCache", "clientCache", "orderCache");
        cacheManager.setCaffeine(caffeineCacheBuilder());
        return cacheManager;
    }

    /**
     * Returns a Caffeine cache builder that sets a 10 minute
     * expire-after-write time and a maximum size of 100.
     *
     * @return a Caffeine cache builder
     */
    Caffeine<Object, Object> caffeineCacheBuilder() {
        return Caffeine.newBuilder()
                .expireAfterWrite(5, TimeUnit.MINUTES) //
                .maximumSize(100); //
    }
}