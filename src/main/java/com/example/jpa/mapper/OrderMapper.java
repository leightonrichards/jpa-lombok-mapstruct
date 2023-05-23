package com.example.jpa.mapper;

import com.example.jpa.domain.Order;
import com.example.jpa.entity.SalesTransaction;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface OrderMapper {
    List<Order> toDomain(List<SalesTransaction> transactions);
    Order toDomain(SalesTransaction transaction);
}
