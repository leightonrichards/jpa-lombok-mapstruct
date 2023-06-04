package com.example.jpa.dto;

import com.example.jpa.entity.SalesTransaction;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 * DTO for {@link SalesTransaction}
 */
@Data
@RequiredArgsConstructor
@Accessors(chain = true)
public class OrderDto implements Serializable {
    private Long id;
    private final Integer orderNumber;
    private final String description;
    private Integer orderValue = 0;
    final private Set<OrderItemDto> orderItems = new LinkedHashSet<>();

    public void addItem(OrderItemDto itemDto) {
        orderItems.add(itemDto);
        itemDto.setParentOrder(this);
        orderValue += itemDto.getItemValue();
    }
}