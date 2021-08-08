package com.antocecere77.redisperformance.controller;

import com.antocecere77.redisperformance.entity.Product;
import com.antocecere77.redisperformance.service.ProductServiceV1;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/product/v1")
@RequiredArgsConstructor
public class ProductControllerV1 {

    private final ProductServiceV1 productService;

    @GetMapping("{id}")
    public Mono<Product> getProduct(@PathVariable int id) {
        return productService.getProduct(id);
    }

    @PutMapping("{id}")
    public Mono<Product> updateProduct(@PathVariable int id, @RequestBody Product product) {
        return productService.updateProduct(id, Mono.just(product));
    }
}









