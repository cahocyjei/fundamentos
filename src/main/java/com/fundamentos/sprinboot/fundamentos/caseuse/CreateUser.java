package com.fundamentos.sprinboot.fundamentos.caseuse;

import com.fundamentos.sprinboot.fundamentos.entitys.User;
import com.fundamentos.sprinboot.fundamentos.services.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
public class CreateUser {

    private UserService userService;

    public CreateUser(UserService userService) {
        this.userService = userService;
    }

    public User saveUser(User user){
        return userService.saveCreateUser(user);
    }
}
