package com.example.jpa.service;

import com.example.jpa.domain.Order;
import com.example.jpa.mapper.OrderMapper;
import com.example.jpa.repository.SalesTransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService{

    @Autowired
    private SalesTransactionRepository repository;

    @Autowired
    private OrderMapper mapper;

    @Override
    public List<Order> fetchOrders() {
        return mapper.toDomain(repository.findAll());
    }

    @Override
    public Order fetchByDescription(String desc) {
        return mapper.toDomain(repository.findByDescription(desc));
    }
}
