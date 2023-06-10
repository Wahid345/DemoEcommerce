package com.example.demoecommerce.dto;


import lombok.Data;

@Data
public class ProductDTO {


    private int id;
    private String name;

    private double price;
    private double weight;
    private String description;
    private String imageName;


    private int categoryId;
}
