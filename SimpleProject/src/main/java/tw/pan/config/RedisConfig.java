package tw.pan.config;

import java.time.Duration;

import org.springframework.boot.autoconfigure.cache.RedisCacheManagerBuilderCustomizer;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializationContext.SerializationPair;
import org.springframework.data.redis.serializer.StringRedisSerializer;

@Configuration
@EnableCaching
public class RedisConfig {

	@Bean
	RedisCacheConfiguration cacheConfiguration() {
	    GenericJackson2JsonRedisSerializer serializer = new GenericJackson2JsonRedisSerializer();
	    return RedisCacheConfiguration.defaultCacheConfig()
	        .entryTtl(Duration.ofMinutes(60))
	        .disableCachingNullValues()
	        .serializeKeysWith(SerializationPair.fromSerializer(new StringRedisSerializer()))
	        .serializeValuesWith(SerializationPair.fromSerializer(serializer));
	}
	
	@Bean
	RedisCacheManagerBuilderCustomizer redisCacheManagerBuilderCustomizer() {
	    return (builder) -> builder
	      .withCacheConfiguration("filmSearchCache",
	    		  RedisCacheConfiguration.defaultCacheConfig().entryTtl(Duration.ofMinutes(1)))
	      .withCacheConfiguration("filmActorCache",
	    		  RedisCacheConfiguration.defaultCacheConfig().entryTtl(Duration.ofMinutes(1)))
	      .withCacheConfiguration("filmCategoryCache", 
	    		  RedisCacheConfiguration.defaultCacheConfig().entryTtl(Duration.ofMinutes(1)))
	      .withCacheConfiguration("customerSearchCache", 
	    		  RedisCacheConfiguration.defaultCacheConfig().entryTtl(Duration.ofMinutes(1)))
	      .withCacheConfiguration("rentalRecordCache", 
	    		  RedisCacheConfiguration.defaultCacheConfig().entryTtl(Duration.ofMinutes(1)))
	      .withCacheConfiguration("paymentRecordCache", 
	    		  RedisCacheConfiguration.defaultCacheConfig().entryTtl(Duration.ofMinutes(1)))
	      .withCacheConfiguration("paymentDateRecordCache", 
	    		  RedisCacheConfiguration.defaultCacheConfig().entryTtl(Duration.ofMinutes(1)));
	}
	
}
