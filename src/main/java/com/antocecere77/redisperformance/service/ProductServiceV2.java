package com.antocecere77.redisperformance.service;

import com.antocecere77.redisperformance.entity.Product;
import com.antocecere77.redisperformance.service.util.CacheTemplate;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class ProductServiceV2 {

    private final CacheTemplate<Integer, Product> cacheTemplate;

    private final ProductVisitService visitService;

    public Mono<Product> getProduct(int id) {

        return cacheTemplate.get(id).doFirst(() -> this.visitService.addVisit(id));
    }

    public Mono<Product> updateProduct(int id, Mono<Product> productMono) {
        return productMono.flatMap(p -> cacheTemplate.update(id, p));
    }

    public Mono<Void> delete(int id) {
        return cacheTemplate.delete(id);
    }
}
