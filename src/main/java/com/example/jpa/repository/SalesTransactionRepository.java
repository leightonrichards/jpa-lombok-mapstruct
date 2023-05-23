package com.example.jpa.repository;

import com.example.jpa.entity.SalesTransaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SalesTransactionRepository extends JpaRepository<SalesTransaction, String> {
    SalesTransaction findByDescription(String desc);
}
