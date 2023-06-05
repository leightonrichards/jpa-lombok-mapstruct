package com.example.jpa.repository;

import com.example.jpa.dto.OrderDto;
import com.example.jpa.dto.OrderItemDto;
import com.example.jpa.service.OrderService;
import com.example.jpa.service.OrderServiceImpl;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class OrderServiceIntegrationTest {

    @Autowired
    private SalesTransactionRepository salesTransactionRepository;

    private OrderService orderService;

    @BeforeAll
    public void init() {
        orderService = new OrderServiceImpl(salesTransactionRepository);
    }

    @Test
    public void orderCanBeFoundByDescription() {
        OrderDto order = orderService.fetchByDescription("SalesTransaction1");
        assertEquals(100, order.getOrderValue());
        assertEquals(1, order.getOrderNumber());
        assertEquals(3, order.getOrderItems().size());
        assertEquals(100, order.getOrderItems().stream().mapToInt(OrderItemDto::getItemValue).sum());
    }

    @Test
    public void whenANewOrderIsCreatedThenOrderCanBeFound() {
        OrderDto order = new OrderDto(4, "SalesTransaction4");
        order.addItem(new OrderItemDto(1, "Item 41", 50));

        orderService.newOrder(order);

        OrderDto foundOrder = orderService.fetchByDescription("SalesTransaction4");
        assertEquals(50, foundOrder.getOrderValue());
        assertEquals(4, foundOrder.getOrderNumber());
        assertEquals(1, foundOrder.getOrderItems().size());
        assertEquals(50, foundOrder.getOrderItems().stream().mapToInt(OrderItemDto::getItemValue).sum());
    }

    @Test
    public void ordersByValueGreaterThan150CanBeFound() {
        List<OrderDto> orderDtos = orderService.findByTransactionValueGreaterThan(150);
        assertEquals(2, orderDtos.size());
    }

    @Test
    public void ordersByValueGreaterThan170CanBeFound() {
        List<OrderDto> orderDtos = orderService.findByTransactionValueGreaterThan170();
        assertEquals(2, orderDtos.size());
    }
}