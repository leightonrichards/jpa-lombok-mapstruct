package com.example.jpa.entity;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Entity
@Table(name = "transaction_item")
public class TransactionItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", columnDefinition = "int UNSIGNED not null")
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "transaction_id", referencedColumnName = "id")
    private SalesTransaction parentTransaction;

    @Column(name = "item_number")
    private Integer itemNumber;

    private String description;

    @Column(name = "item_value", nullable = false)
    private Integer itemValue;

}