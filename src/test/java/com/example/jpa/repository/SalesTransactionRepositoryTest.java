package com.example.jpa.repository;

import com.example.jpa.entity.SalesTransaction;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class SalesTransactionRepositoryTest {
    private static Log log = LogFactory.getLog(SalesTransactionRepositoryTest.class);

    @Autowired
    private SalesTransactionRepository salesTransactionRepository;

    @Test
    public void whenOrderIsInserted_thenOrderCanBeFound() {
        SalesTransaction order = salesTransactionRepository.findByDescription("SalesTransaction1");
        assertEquals(100, order.getTransactionValue());
    }
}