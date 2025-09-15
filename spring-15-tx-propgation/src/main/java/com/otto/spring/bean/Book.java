package com.otto.spring.bean;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class Book {
    private Integer id;
    private String bookName;
    private BigDecimal price;
    private Integer stock;
}
