package com.example.demoecommerce.Service;

import com.example.demoecommerce.Entities.Category;
import com.example.demoecommerce.Repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;



    public void AddCategory(Category category) {

        categoryRepository.save(category);
    }


    public List<Category> getAllCategory() {
        return categoryRepository.findAll();
    }

    public void removeCategoryById(int Id){
        categoryRepository.deleteById(Id);
    }

    public Optional<Category> getCategoryById(int id){

        return categoryRepository.findById(id);

    }
}
