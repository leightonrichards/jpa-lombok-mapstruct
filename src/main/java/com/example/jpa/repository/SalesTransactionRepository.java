package com.example.jpa.repository;

import com.example.jpa.entity.SalesTransaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SalesTransactionRepository extends JpaRepository<SalesTransaction, String> {
    SalesTransaction findByDescription(String desc);

    List<SalesTransaction> findByTransactionValueGreaterThan(Integer value);

    @Query(value = "select t from SalesTransaction t where t.transactionValue > :value ")
    List<SalesTransaction> findByCustomQuery(Integer value);
}
