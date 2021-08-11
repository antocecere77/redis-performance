package com.antocecere77.redisperformance.controller;

import com.antocecere77.redisperformance.service.BusinessMetricService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

import java.time.Duration;
import java.util.Map;

@RestController
@RequestMapping("product/metrics")
@RequiredArgsConstructor
public class BusinessMetricsController {

    public final BusinessMetricService businessMetricService;

    @GetMapping(produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<Map<Integer, Double>> getMetrics() {
        return this.businessMetricService.top3Product()
                .repeatWhen(l -> Flux.interval(Duration.ofSeconds(3)));
    }
}

















