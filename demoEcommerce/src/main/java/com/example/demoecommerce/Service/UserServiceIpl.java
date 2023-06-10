package com.example.demoecommerce.Service;



import com.example.demoecommerce.Entities.Register;
import com.example.demoecommerce.Repository.RegisterRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceIpl implements UserService{
    @Autowired
    private RegisterRepository registerRepo;
    @Autowired
    private BCryptPasswordEncoder passwordEncoder;


    @Override
    public Register CreateUser(Register register)
    {

        register.setUserPassword(register.getUserPassword());
//        register.setRole("ROLE_USER");
        return registerRepo.save(register);
    }

//    @Override
//    public boolean checkEmail(String UserEmail)
//    {
//        return registerRepo.existsByUserEmail(UserEmail);
//    }
}
