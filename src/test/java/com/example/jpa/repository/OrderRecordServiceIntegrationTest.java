package com.example.jpa.repository;

import com.example.jpa.record.OrderItemRecord;
import com.example.jpa.record.OrderRecord;
import com.example.jpa.service.OrderRecordService;
import com.example.jpa.service.OrderRecordServiceImpl;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class OrderRecordServiceIntegrationTest {

    @Autowired
    private SalesTransactionRepository salesTransactionRepository;

    private OrderRecordService orderService;

    @BeforeAll
    public void init() {
        orderService = new OrderRecordServiceImpl(salesTransactionRepository);
    }

    @Test
    public void orderCanBeFoundByDescription() {
        OrderRecord order = orderService.fetchByDescription("SalesTransaction1");
        assertEquals(100, order.orderValue());
        assertEquals(1, order.orderNumber());
        assertEquals(3, order.orderItems().size());
        assertEquals(100, order.orderItems().stream().mapToInt(OrderItemRecord::itemValue).sum());
    }

}