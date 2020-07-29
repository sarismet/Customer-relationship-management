package com.intertech.cix.service;


import com.intertech.cix.model.User;
import com.intertech.cix.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private UserRepository userRepository;

    @Autowired
    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User getUser(){
        return  userRepository.findById("5f086208e69f4225dc55af75").get();
    }
}
