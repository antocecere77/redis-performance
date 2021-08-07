package com.antocecere77.redisperformance.controller;

import com.antocecere77.redisperformance.entity.Product;
import com.antocecere77.redisperformance.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/product")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @GetMapping("{id}")
    public Mono<Product> getProduct(@PathVariable int id) {
        return productService.getProduct(id);
    }

    @PutMapping("{id}")
    public Mono<Product> updateProduct(@PathVariable int id, @RequestBody Mono<Product> productMono) {
        return productService.updateProduct(id, productMono);
    }
}









