package com.example.jpa.mapper;

import com.example.jpa.entity.TransactionItem;
import com.example.jpa.record.OrderItemRecord;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface OrderItemRecordMapper {
    TransactionItem toEntity(OrderItemRecord orderItemRecord);

    OrderItemRecord toDto(TransactionItem transactionItem);
}