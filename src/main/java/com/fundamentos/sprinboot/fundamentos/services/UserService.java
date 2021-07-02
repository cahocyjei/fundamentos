package com.fundamentos.sprinboot.fundamentos.services;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fundamentos.sprinboot.fundamentos.entitys.User;
import com.fundamentos.sprinboot.fundamentos.repository.UserRepository;

@Service
public class UserService {
	
	private final Log LOGGER = LogFactory.getLog(UserService.class);
	
	private UserRepository userRepository;

	public UserService(UserRepository userRepository) {
		
		this.userRepository = userRepository;
	}
	
	@Transactional
	public void saveUser(List<User> listU) {
		
		listU.stream().peek(user->LOGGER.info("Usuario Insertado"  + user))
		.forEach(userRepository::save);		
	}
	
	public List<User> getAllUsers(){
		
		return userRepository.findAll();
	}

}
