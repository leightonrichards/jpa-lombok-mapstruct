package com.example.jpa.service;

import com.example.jpa.dto.OrderDto;
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
    public List<OrderDto> fetchOrders() {
        return mapper.toDto(repository.findAll());
    }

    @Override
    public OrderDto fetchByDescription(String desc) {
        return mapper.toDto(repository.findByDescription(desc));
    }
}
