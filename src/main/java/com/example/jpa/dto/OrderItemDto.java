package com.example.jpa.dto;

import com.example.jpa.entity.TransactionItem;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * DTO for {@link TransactionItem}
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class OrderItemDto implements Serializable {
    private Long id;
    @JsonIgnore
    private OrderDto parentOrder;
    private Integer itemNumber;
    private String description;
    private Integer itemValue;
}