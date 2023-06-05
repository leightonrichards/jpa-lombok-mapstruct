package com.example.jpa.service;

import com.example.jpa.mapper.OrderRecordMapper;
import com.example.jpa.record.OrderRecord;
import com.example.jpa.repository.SalesTransactionRepository;
import org.mapstruct.factory.Mappers;

public class OrderRecordServiceImpl implements OrderRecordService {
    private final SalesTransactionRepository repository;

    private final OrderRecordMapper mapper = Mappers.getMapper(OrderRecordMapper.class);

    public OrderRecordServiceImpl(SalesTransactionRepository repository) {
        this.repository=repository;
    }

    @Override
    public OrderRecord fetchByDescription(String desc) {
        return mapper.toDto(repository.findByDescription(desc));
    }
}