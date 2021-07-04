package com.fundamentos.sprinboot.fundamentos.caseuse;

import com.fundamentos.sprinboot.fundamentos.entitys.User;
import com.fundamentos.sprinboot.fundamentos.services.UserService;

import java.util.List;

public class GetUserImplement implements GetUser {

    private UserService userService;

    public GetUserImplement(UserService userService) {
        this.userService = userService;
    }

    @Override
    public List<User> getAll() {
        return userService.getAllUsers();
    }
}
