package com.example.jpa.mapper;

import com.example.jpa.dto.OrderItemDto;
import com.example.jpa.entity.TransactionItem;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface OrderItemMapper {
    TransactionItem toEntity(OrderItemDto orderItemDto);

    OrderItemDto toDto(TransactionItem transactionItem);
}