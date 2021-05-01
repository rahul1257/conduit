package com.spring.conduit.contollers;

import com.spring.conduit.entities.ErrorEntity;
import com.spring.conduit.entities.UserEntity;
import com.spring.conduit.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class ProfilesController {
    @Autowired
    private UserService users;

    @GetMapping("/profiles/{username}")
    UserEntity getUserByUserName(@PathVariable("username") String username) {
        return users.findUserByUsername(username);
    }

    @ExceptionHandler(RuntimeException.class)
    ResponseEntity<ErrorEntity> handleExceptions(RuntimeException exception) {
        String message = exception.getMessage();
        HttpStatus errorStatus = HttpStatus.INTERNAL_SERVER_ERROR;
        if(exception instanceof  UserService.UserNotFoundException) {
            errorStatus = HttpStatus.NOT_FOUND;
        }
        return new ResponseEntity<ErrorEntity>(
                ErrorEntity.from(message),
                errorStatus
        );
    }
}
