package com.example.demoecommerce.Controllers;


import com.example.demoecommerce.Entities.Register;

import com.example.demoecommerce.Service.UserServiceIpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class RegisterController {

    @Autowired
    private UserServiceIpl userServiceIpl;



    @GetMapping("/register")
    public String goRegister(){

        return "register";
    }
    @PostMapping("/createUser")
    public String createUser(@ModelAttribute Register register) {

//           boolean f= userServiceIpl.checkEmail(register.getUserEmail());


        System.out.println(register);

        Register reg=userServiceIpl.CreateUser(register);

        if(reg !=null){
            System.out.println("Registration Successfully...");
        }else{
            System.out.println("Some Error in Server...");
        }


        return "redirect:/register";
    }
}
