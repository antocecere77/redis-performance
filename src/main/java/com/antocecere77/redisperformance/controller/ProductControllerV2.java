package com.antocecere77.redisperformance.controller;

import com.antocecere77.redisperformance.entity.Product;
import com.antocecere77.redisperformance.service.ProductServiceV1;
import com.antocecere77.redisperformance.service.ProductServiceV2;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/product/v2")
@RequiredArgsConstructor
public class ProductControllerV2 {

    private final ProductServiceV2 productService;

    @GetMapping("{id}")
    public Mono<Product> getProduct(@PathVariable int id) {
        return productService.getProduct(id);
    }

    @PutMapping("{id}")
    public Mono<Product> updateProduct(@PathVariable int id, @RequestBody Mono<Product> productMono) {
        return productService.updateProduct(id, productMono);
    }

    @DeleteMapping("{id}")
    public Mono<Void> deleteProduct(@PathVariable int id) {
        return productService.delete(id);
    }
}









