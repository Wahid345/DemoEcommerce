package com.example.demoecommerce.SecurityConfiguration;


import com.example.demoecommerce.Entities.User;
import com.example.demoecommerce.Repository.RegisterRepository;
import com.example.demoecommerce.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class UserDetailServicempl implements UserDetailsService {

    @Autowired
   private RegisterRepository registerRepository;



    @Override
    public UserDetails loadUserByUsername(String Email) throws UsernameNotFoundException {

       User user= registerRepository.findByEmail(Email);

       if(user != null){

           return new CustomUserDetails(user);
       }

        throw new UsernameNotFoundException("user not available");
    }
}
