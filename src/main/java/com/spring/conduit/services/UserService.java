package com.spring.conduit.services;

import com.spring.conduit.entities.UserEntity;
import com.spring.conduit.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    public static class UserNotFoundException extends RuntimeException {
        public UserNotFoundException() {
            super("No such User not found");
        }
    }
    @Autowired
    private UserRepository userRepo;

    public UserEntity findUserByUsername(String username) {
        UserEntity user = userRepo.findUserEntityByUsername(username);
        //if(user == null) throw new UserNotFoundException();
        return userRepo.findUserEntityByUsername(username);
    }
}
