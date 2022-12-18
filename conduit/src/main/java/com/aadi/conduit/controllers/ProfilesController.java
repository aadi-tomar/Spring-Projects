package com.aadi.conduit.controllers;

import com.aadi.conduit.DTO.UserSignupDto;
import com.aadi.conduit.entities.ErrorEntity;
import com.aadi.conduit.entities.UserEntity;
import com.aadi.conduit.services.UserService;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class ProfilesController {

    @Autowired
    private  UserService userService;

    @GetMapping("/profiles/{username}")
    ResponseEntity<UserEntity> getProfileByUserName(@PathVariable("username") String username ){
        return new ResponseEntity<>(userService.findUserByUserName(username), HttpStatus.OK);

    }

    @PostMapping("/users")
    ResponseEntity<UserEntity>  registerUser(@RequestBody UserSignupDto userSignupDto){

        UserEntity newUser = userService.registerNewUser(userSignupDto.getUser().getUsername(),
                userSignupDto.getUser().getPassword(), userSignupDto.getUser().getEmail());

        return new ResponseEntity< >( newUser, HttpStatus.CREATED ) ;

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
