package com.aadi.conduit.services;

import com.aadi.conduit.entities.UserEntity;
import com.aadi.conduit.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public UserEntity findUserByUserName(String username){
        UserEntity user = userRepository.findByUserName(username);
        if (user == null){
            throw new UserNotFoundException("User not found");
        }
        return user;
    }


    public static class UserNotFoundException extends RuntimeException{
        public UserNotFoundException(String message){
            super(message);
        }
    }
}
