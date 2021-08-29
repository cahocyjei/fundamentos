package com.fundamentos.sprinboot.fundamentos.caseuse;

import com.fundamentos.sprinboot.fundamentos.entitys.User;
import com.fundamentos.sprinboot.fundamentos.services.UserService;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PageableUser {

    private UserService userService;

    public PageableUser(UserService userService) {
        this.userService = userService;
    }


}
