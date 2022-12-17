package com.aadi.conduit.controllers;

import com.aadi.conduit.entities.ErrorEntity;
import com.aadi.conduit.entities.UserEntity;
import com.aadi.conduit.services.UserService;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProfilesController {

    @Autowired
    private UserService userService;

    @GetMapping("/profiles/{username}")
    UserEntity getProfileByUserName(String username ){
        return userService.findUserByUserName(username);

    }


    @ExceptionHandler(RuntimeException.class)
    ResponseEntity<ErrorEntity> handleException(RuntimeException exception){
        String message = exception.getMessage();
        HttpStatus errorStatus = HttpStatus.INTERNAL_SERVER_ERROR;

        if(exception instanceof UserService.UserNotFoundException){
            errorStatus = HttpStatus.NOT_FOUND;
        }
        return new ResponseEntity < ErrorEntity>(
                ErrorEntity.from(message), errorStatus
        );
    }


}
