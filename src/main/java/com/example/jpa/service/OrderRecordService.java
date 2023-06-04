package com.example.jpa.service;

import com.example.jpa.record.OrderRecord;

public interface OrderRecordService {
    OrderRecord fetchByDescription(String desc);
}
