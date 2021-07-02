package com.fundamentos.sprinboot.fundamentos.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.fundamentos.sprinboot.fundamentos.beans.MyBeanWithProperties;
import com.fundamentos.sprinboot.fundamentos.beans.MyBeanWithPropertiesImplement;
import com.fundamentos.sprinboot.fundamentos.pojos.UserPojo;

@EnableConfigurationProperties(UserPojo.class)
@Configuration
public class ConfigurationPojos {
	
	@Value("${value.name}")
	private String name;
	
	@Value("${value.apellido}")
	private String apellido;
	
	@Bean
	public MyBeanWithProperties function() {
		
		return new MyBeanWithPropertiesImplement(name,apellido);
	}
	

}
