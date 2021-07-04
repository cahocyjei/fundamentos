package com.fundamentos.sprinboot.fundamentos.caseuse;

import com.fundamentos.sprinboot.fundamentos.services.UserService;
import org.springframework.stereotype.Component;

@Component
public class DeleteUser {
    private UserService userService;

    public DeleteUser(UserService userService) {
        this.userService = userService;
    }


    public void remove(long id) {
        userService.delete(id);
    }
}
