package com.example.demoecommerce.Repository;

import com.example.demoecommerce.Entities.Register;
import com.example.demoecommerce.Entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;


@Repository

public interface RegisterRepository extends JpaRepository<Register,Integer> {

//         boolean existsByUserEmail(String UserEmail);
            public User findByEmail(String Email);

}
