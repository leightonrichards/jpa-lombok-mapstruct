package com.example.jpa.mapper;

import com.example.jpa.dto.OrderDto;
import com.example.jpa.entity.SalesTransaction;
import org.mapstruct.*;

import java.util.List;

//@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, uses = {OrderItemMapper.class})
public interface OrderMapper {
    @Mapping(source = "orderValue", target = "transactionValue")
    @Mapping(source = "orderNumber", target = "transactionNumber")
    @Mapping(source = "orderItems", target = "transactionItems")
    SalesTransaction toEntity(OrderDto orderDto);

    @AfterMapping
    default void linkTransactionItems(@MappingTarget SalesTransaction salesTransaction) {
        salesTransaction.getTransactionItems().forEach(transactionItem -> transactionItem.setParentTransaction(salesTransaction));
    }

    @AfterMapping
    default void linkOrderItems(@MappingTarget OrderDto orderDto) {
        orderDto.getOrderItems().forEach(orderItemDto -> orderItemDto.setParentOrder(orderDto));
    }

    @InheritInverseConfiguration(name = "toEntity")
    OrderDto toDto(SalesTransaction salesTransaction);


    List<OrderDto> toDto(List<SalesTransaction> salesTransactions);
}