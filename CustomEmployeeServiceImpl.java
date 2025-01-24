package com.example.ems.serviceImpl;

import com.example.ems.dao.LoginDetailsDao;
import com.example.ems.entity.LoginDetails;
import com.example.ems.exceptionClasses.InvalidEmployeeCredentialsException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Component;

@Component
public class CustomEmployeeServiceImpl implements UserDetailsService {

    @Autowired
    private LoginDetailsDao loginDetailsDao;


    @Override
    public UserDetails loadUserByUsername(String email) {

        LoginDetails loginDetails = loginDetailsDao.findByEmail(email).orElseThrow(()-> new
                InvalidEmployeeCredentialsException("Login Details Not Found For Given Email Id"));

        return User
                .withUsername(loginDetails.getEmail())
                .password(loginDetails.getPassword())
                .roles("USER")
                .build();
    }
}
