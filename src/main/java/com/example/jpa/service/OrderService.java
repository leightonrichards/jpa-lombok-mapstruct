package com.example.jpa.service;

import com.example.jpa.dto.OrderDto;

import java.util.List;

public interface OrderService {
    List<OrderDto> fetchOrders();
    OrderDto fetchByDescription(String desc);

    OrderDto newOrder(OrderDto newOrder);
}
