package com.example.demoecommerce.Entities;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "category_id")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "category_id")
    private int id;
    private String name;




}
