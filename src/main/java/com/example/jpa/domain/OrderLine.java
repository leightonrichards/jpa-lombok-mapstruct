package com.example.jpa.domain;

import lombok.Data;

import java.math.BigInteger;

@Data
public class OrderLine {
    private BigInteger id;
    private Order order;
    private String name;
    private String description;
    private Integer itemValue;
}
