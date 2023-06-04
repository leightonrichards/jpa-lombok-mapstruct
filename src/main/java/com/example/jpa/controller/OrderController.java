package com.example.jpa.controller;

import com.example.jpa.dto.OrderDto;
import com.example.jpa.service.OrderService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value="v1/order")
public class OrderController {

    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping(
            value = {"/{description}"},
            produces = {"application/json"}
    )
    OrderDto findByDescription(@PathVariable String description) {
        return orderService.fetchByDescription(description);
    }

    @GetMapping(
            value = {"/"},
            produces = {"application/json"}
    )
    List<OrderDto> findAll() {
        return orderService.fetchOrders();
    }
}
