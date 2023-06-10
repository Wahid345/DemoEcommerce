package com.example.demoecommerce.Repository;

import com.example.demoecommerce.Entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository  extends JpaRepository<Category, Integer> {
}
