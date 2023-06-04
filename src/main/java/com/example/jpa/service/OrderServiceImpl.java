package com.example.jpa.service;

import com.example.jpa.dto.OrderDto;
import com.example.jpa.mapper.OrderMapper;
import com.example.jpa.repository.SalesTransactionRepository;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService{

    private SalesTransactionRepository repository;

    private OrderMapper mapper = Mappers.getMapper(OrderMapper.class);

    public OrderServiceImpl(SalesTransactionRepository repository) {
        this.repository=repository;
    }

    @Override
    public List<OrderDto> fetchOrders() {
        return mapper.toDto(repository.findAll());
    }

    @Override
    public OrderDto fetchByDescription(String desc) {
        return mapper.toDto(repository.findByDescription(desc));
    }

    public OrderDto newOrder(OrderDto newOrder) {
        return mapper.toDto(repository.save(mapper.toEntity(newOrder)));
    }
}
