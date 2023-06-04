package com.example.jpa.record;

import java.io.Serializable;

/**
 * DTO for {@link com.example.jpa.entity.TransactionItem}
 */
public record OrderItemRecord(Long id, OrderRecord parentTransaction, Integer itemNumber, String description,
                              Integer itemValue) implements Serializable {
}