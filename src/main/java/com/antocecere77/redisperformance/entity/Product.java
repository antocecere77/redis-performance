package com.antocecere77.redisperformance.entity;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Data
@Table
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Product {

    @Id
    private Integer id;

    private String description;

    private double price;
}
