package com.example.demoecommerce.Entities;

import jakarta.persistence.*;
import lombok.Data;
@Entity
@Data
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @ManyToOne
    @JoinColumn(name = "category_id" , referencedColumnName="category_id")
    private Category category;
    private String name;

    private double price;
    private double weight;
    private String description;
    private String imageName;




}
