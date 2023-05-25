package com.example.jpa.dto;

import com.example.jpa.entity.SalesTransaction;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 * DTO for {@link SalesTransaction}
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class OrderDto implements Serializable {
    private Long id;
    private Integer orderNumber;
    private String description;
    private Integer orderValue;
    private Set<OrderItemDto> orderItems = new LinkedHashSet<>();
}