package com.fundamentos.sprinboot.fundamentos.caseuse;

import com.fundamentos.sprinboot.fundamentos.services.UserService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UserCaseConfiguration {

    @Bean
    public GetUser userCase(UserService userService){
        return new GetUserImplement(userService);
    }
}
