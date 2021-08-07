package com.antocecere77.redisperformance.service;

import com.antocecere77.redisperformance.entity.Product;
import com.antocecere77.redisperformance.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;

    public Mono<Product> getProduct(int id) {
        return productRepository.findById(id);
    }

    public Mono<Product> updateProduct(int id, Mono<Product> productMono) {
        return productRepository.findById(id)
                .flatMap(p -> productMono.doOnNext(pr -> pr.setId(id)))
                .flatMap(productRepository::save);
    }
}

















