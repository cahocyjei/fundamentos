package com.fundamentos.sprinboot.fundamentos.configuration;

import com.fundamentos.sprinboot.fundamentos.beans.Mybean;
import com.fundamentos.sprinboot.fundamentos.beans.MybeanImplement;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyConfigurationBean {

    @Bean
    public Mybean operationBean(){
        return new MybeanImplement();
    }
}
