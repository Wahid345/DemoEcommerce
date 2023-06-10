package com.example.demoecommerce.Service;

import com.example.demoecommerce.Entities.Register;
import org.springframework.stereotype.Service;

@Service
public interface UserService {
     Register CreateUser(Register register);

//     boolean checkEmail(String UserEmail);

}
