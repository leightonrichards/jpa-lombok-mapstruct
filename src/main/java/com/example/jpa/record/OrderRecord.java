package com.example.jpa.record;

import java.io.Serializable;
import java.util.Set;

/**
 * DTO for {@link com.example.jpa.entity.SalesTransaction}
 */
public record OrderRecord(Long id,
                          Integer orderNumber,
                          String description,
                          Integer orderValue,
                          Set<OrderItemRecord> orderItems) implements Serializable {
}