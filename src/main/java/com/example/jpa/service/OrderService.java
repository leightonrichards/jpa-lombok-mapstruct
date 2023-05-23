package com.example.jpa.service;

import com.example.jpa.domain.Order;

import java.util.List;

public interface OrderService {
    List<Order> fetchOrders();
    Order fetchByDescription(String desc);
}
