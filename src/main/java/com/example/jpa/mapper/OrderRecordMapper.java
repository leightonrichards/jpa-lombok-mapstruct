package com.example.jpa.mapper;

import com.example.jpa.entity.SalesTransaction;
import com.example.jpa.record.OrderRecord;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, uses = {OrderItemRecordMapper.class})
public interface OrderRecordMapper {
    @Mapping(source = "orderValue", target = "transactionValue")
    @Mapping(source = "orderNumber", target = "transactionNumber")
    @Mapping(source = "orderItems", target = "transactionItems")
    SalesTransaction toEntity(OrderRecord orderRecord);

    @AfterMapping
    default void linkTransactionItems(@MappingTarget SalesTransaction salesTransaction) {
        salesTransaction.getTransactionItems().forEach(transactionItem -> transactionItem.setParentTransaction(salesTransaction));
    }

    @AfterMapping
    default void linkOrderItems(@MappingTarget OrderRecord orderRecord) {
         /*
         *  Cant link Order Items  as the OrderRecord is immutable
         */
//        orderRecord.orderItems().forEach(orderItemRecord -> orderItemRecord.setParentOrder(orderRecord));
    }

    @InheritInverseConfiguration(name = "toEntity")
    OrderRecord toDto(SalesTransaction salesTransaction);
}