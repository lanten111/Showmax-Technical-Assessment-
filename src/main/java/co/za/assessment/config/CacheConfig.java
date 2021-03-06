//package co.za.assessment.config;
///*
//created by mumakhado on 2021/03/05
//*/
//
//import org.springframework.boot.autoconfigure.cache.CacheProperties;
//import org.springframework.cache.CacheManager;
////import org.springframework.cache.caffeine.CaffeineCacheManager;
//import org.springframework.context.annotation.Bean;
//
//public class CacheConfig {
//
//        @Bean
//        public CacheManager cacheManager() {
//            CaffeineCacheManager cacheManager = new CaffeineCacheManager("customer");
//            cacheManager.setCaffeine(caffeineCacheBuilder());
//            return cacheManager;
//        }
//
//        Caffeine < Object, Object > caffeineCacheBuilder() {
//            return CacheProperties.Caffeine.newBuilder()
//                    .initialCapacity(100)
//                    .maximumSize(500)
//                    .expireAfterAccess(10, TimeUnit.MINUTES)
//                    .weakKeys()
//                    .recordStats();
//        }
//    }
//
