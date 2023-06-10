package com.example.demoecommerce.Service;


import com.example.demoecommerce.Entities.Product;
import com.example.demoecommerce.Repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    ProductRepository productRepository;
    public List<Product> getAllProduct() {
        return productRepository.findAll();
    }

    public void productAdd(Product product){
        productRepository.save(product);
    }

    public void removeProductById(int id){
        productRepository.deleteById(id);

    }
    public Optional<Product> getProductById(int id){

        return productRepository.findById(id);

    }
    public List<Product> getAllproductByCategoryId(int id){
        return productRepository.findAllByCategoryId(id);
    }
}
