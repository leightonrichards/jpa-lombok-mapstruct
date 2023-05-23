package com.example.jpa.domain;

import lombok.Data;

import java.math.BigInteger;
import java.util.List;

@Data
public class Order {
    private BigInteger id;
    private String description;
    private Integer transactionValue;

    private Integer transactionNumber;

    List<OrderLine> orderLines;
}
