package com.example.jpa.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "transaction_item")
public class TransactionItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", columnDefinition = "int UNSIGNED not null")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "transaction_number", referencedColumnName = "transaction_number")
    private SalesTransaction transactionNumber;

    @Column(name = "item_number")
    private Integer itemNumber;

    @Column(name = "description", nullable = false, length = 25)
    private String description;

    @Column(name = "item_value", nullable = false)
    private Integer itemValue;

}