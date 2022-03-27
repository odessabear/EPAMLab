package com.example.webprovider.domain.model;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Builder
public class Tariff {

    private Integer id;

    private String name;

    private String description;

    private String imageLink;

    private BigDecimal price;

    private Category category;
}
