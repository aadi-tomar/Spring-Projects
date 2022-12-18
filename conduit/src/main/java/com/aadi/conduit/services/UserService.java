package com.aadi.conduit.services;

import com.aadi.conduit.entities.UserEntity;
import com.aadi.conduit.repositories.UserRepository;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private  UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    private JWTService jwtService;

    @Bean
    public static BCryptPasswordEncoder bcryptEncoder(){
        return new BCryptPasswordEncoder();
    }

    public UserEntity findUserByUserName(String username){
        UserEntity user = userRepository.findByUserName(username);
        if (user == null){
            throw new UserNotFoundException("User not found");
        }
        return user;
    }

    public UserEntity registerNewUser(String username, String password, String email){

        UserEntity userEntity = new UserEntity();
        userEntity.setUserName(username);
        userEntity.setEmail(email);
        userEntity.setPassword(bCryptPasswordEncoder.encode(password));
        userEntity =  userRepository.save(userEntity);
        userEntity.setToken(jwtService.createJWT(userEntity));
        return  userEntity;

    }
    /*
    public UserEntity verifyUser(String email, String password){


    }

    public UserEntity findUserById(Long userId){

    }

    public UserEntity updateUserDetails(UserEntity userEntity ){

    }

    */
    public static class UserNotFoundException extends RuntimeException{
        public UserNotFoundException(String message){
            super(message);
        }
    }
}
