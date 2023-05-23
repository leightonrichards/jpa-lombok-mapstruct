package com.example.jpa.controller;

import com.example.jpa.domain.Order;
import com.example.jpa.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value="v1/order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @GetMapping(
            value = {"/{description}"},
            produces = {"application/json"}
    )
    Order findByDescription(String description) {
        return orderService.fetchByDescription(description);
    }

    @GetMapping(
            value = {"/"},
            produces = {"application/json"}
    )
    List<Order> findAll() {
        return orderService.fetchOrders();
    }
}
