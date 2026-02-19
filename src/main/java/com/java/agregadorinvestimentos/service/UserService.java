package com.java.agregadorinvestimentos.service;

import java.time.Instant;
import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.java.agregadorinvestimentos.controller.CreateUserDTO;
import com.java.agregadorinvestimentos.entity.User;
import com.java.agregadorinvestimentos.repository.UserRepository;

@Service
public class UserService {

    private UserRepository userRepository; 

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    public UUID createUser(CreateUserDTO createUserDTO){
        // DTO --> Entity
        var entity = new User(UUID.randomUUID(), 
        createUserDTO.username(), 
        createUserDTO.email(), 
        createUserDTO.password(),
        Instant.now(),
        null );

        var userSaved = userRepository.save(entity);

        return userSaved.getUserID();
    }

    public Optional<User> getUserById(String userId){
        return userRepository.findById(UUID.fromString(userId));
        
    }
}
