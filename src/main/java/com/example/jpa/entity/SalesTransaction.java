package com.example.jpa.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.LinkedHashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "sales_transaction")
public class SalesTransaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", columnDefinition = "int UNSIGNED not null")
    private Long id;

    @Column(name = "transaction_number", nullable = false)
    private Integer transactionNumber;

    @Column(name = "description", nullable = false, length = 25)
    private String description;

    @Column(name = "transaction_value", nullable = false)
    private Integer transactionValue;

    @OneToMany(mappedBy = "parentTransaction")
    private Set<TransactionItem> transactionItems = new LinkedHashSet<>();

}