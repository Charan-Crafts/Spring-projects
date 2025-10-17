package com.growandshine.Spring.security.Services;

import com.growandshine.Spring.security.Entites.Users;
import com.growandshine.Spring.security.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomUserDetailService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Optional<Users> user = userRepository.findByUserName(username);

        if(user==null){
            throw new UsernameNotFoundException("User not found");
        }

        return new CustomUserDetails(user.get());
    }
}
