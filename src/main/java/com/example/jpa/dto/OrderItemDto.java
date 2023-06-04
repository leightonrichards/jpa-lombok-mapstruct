package com.example.jpa.dto;

import com.example.jpa.entity.TransactionItem;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * DTO for {@link TransactionItem}
 */
@Data
@RequiredArgsConstructor
@Accessors(chain = true)
public class OrderItemDto implements Serializable {
    private Long id;
    @JsonIgnore
    private OrderDto parentOrder;
    private final Integer itemNumber;
    private final String description;
    private final Integer itemValue;
}