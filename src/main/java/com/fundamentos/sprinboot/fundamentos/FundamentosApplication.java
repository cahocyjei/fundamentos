package com.fundamentos.sprinboot.fundamentos;

import com.fundamentos.sprinboot.fundamentos.beans.MyBeanWithDependency;
import com.fundamentos.sprinboot.fundamentos.beans.MyBeanWithProperties;
import com.fundamentos.sprinboot.fundamentos.beans.Mybean;
import com.fundamentos.sprinboot.fundamentos.component.ComponentDependency;
import com.fundamentos.sprinboot.fundamentos.entitys.User;
import com.fundamentos.sprinboot.fundamentos.pojos.UserPojo;
import com.fundamentos.sprinboot.fundamentos.repository.UserRepository;
import com.fundamentos.sprinboot.fundamentos.services.UserService;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.domain.Sort;

@SpringBootApplication
public class FundamentosApplication implements CommandLineRunner {

	private final Log LOGGER = LogFactory.getLog(FundamentosApplication.class);
	
	public static void main(String[] args) {
		SpringApplication.run(FundamentosApplication.class, args);
	}

	private ComponentDependency componentDependency;
	private Mybean myBean;
	private UserRepository userRepository;
	private MyBeanWithDependency myBeanWithDependency;
	private MyBeanWithProperties myBeanWithProperties;
	private UserPojo userPojo;
	private UserService userService;

	public FundamentosApplication(@Qualifier("componentImplement2") ComponentDependency componentDependency, 
			Mybean myBean, UserRepository userRepository,
			MyBeanWithDependency myBeanWithDependency, MyBeanWithProperties myBeanWithProperties
			,UserPojo userPojo,UserService userService){
		
		this.componentDependency= componentDependency;
		this.myBean = myBean;
		this.userRepository=userRepository;
		this.myBeanWithDependency= myBeanWithDependency;
		this.myBeanWithProperties= myBeanWithProperties;
		this.userPojo= userPojo;
		this.userService=userService;
	}

	private void saveUserDatabase() {
		
		User user1 = new User("Omar","cahocyjei@gmail.com",LocalDate.of(2021, 01, 12));
		User user2 = new User("Camilo","drecito09Hobby@gmail.com",LocalDate.of(2020, 04, 11));
		User user3 = new User("user1","hocytica@gmail.com",LocalDate.of(2020, 01, 10));
		User user4 = new User("user2","homartica@gmail.com",LocalDate.of(2021, 05, 07));
		User user5 = new User("user3","hocyticca@gmail.com",LocalDate.of(2021, 02, 01));
		
		List<User> listU = Arrays.asList(user1,user2,user3,user4,user5);
		listU.stream()
		.forEach(userRepository::save);
		
	}
	
	public void getInformationJpqlUser() {
		
		/*LOGGER.info("Usuario con el metodo findByUserEmail: "
		+ userRepository.findByUserEmail("cahocyjei@gmail.com")
		.orElseThrow(()->new RuntimeException("No se encontro el Usuario")));
		
		userRepository.findAndSort("user", Sort.by("id").descending())
		.stream()
		.forEach(user->LOGGER.info("Usuarios con el metodo findAndSort" + user));
		
		userRepository.findByName("Omar")
		.stream()
		.forEach(user->LOGGER.info("Usuario con metodo Query findByName" + user));
		
		LOGGER.info("Usuario con metodo findByEmailAndName" +  userRepository.findByEmailAndName("drecito09Hobby@gmail.com", "Camilo")
		.orElseThrow(()->new RuntimeException("Usuario no Encontrado")));
		
		userRepository.findByNameLike("%u%")
		.stream()
		.forEach(user->LOGGER.info("Usuario con metodo Query findByNameLike" + user));
		
		userRepository.findByNameOrEmail("Omar",null)
		.stream()
		.forEach(user->LOGGER.info("Usuario con metodo Query findByNameOrEmail" + user));
		
		userRepository.findByBirthDateBetween(LocalDate.of(2021, 01, 12), LocalDate.of(2021, 12, 12))
		.stream()
		.forEach(user->LOGGER.info("Usuarios con intervalo de fechas" +  user));
		
		userRepository.findByNameLikeOrderByIdDesc("%user%")
		.stream()
		.forEach(user->LOGGER.info("Usuario encontrado con like y ordenado" + user));
		
		LOGGER.info("Usuario Encontrado Con NameParametro: " + userRepository.getAllByBirthDateAndEmail(LocalDate.of(2021, 01, 12), "cahocyjei@gmail.com")
		.orElseThrow(()->new RuntimeException("Usuario no Encontrado")));*/
	}
	
	private void saveWithErrorTransactional() {
		User user1 = new User("Transactional1","transactional1@hotmail.com",LocalDate.now());
		User user2 = new User("Transactional2","transactional2@hotmail.com",LocalDate.now());
		User user3 = new User("Transactional3","transactional1@hotmail.com",LocalDate.now());
		User user4 = new User("Transactional4","transactional4@hotmail.com",LocalDate.now());
		
		List<User> users = Arrays.asList(user1,user2,user3,user4);
		
		try{
			
		userService.saveUser(users);
		
		}catch(Exception e){
			
			LOGGER.info("Este es un error Transaccional" + e);
		}
		
		userService.getAllUsers().stream().forEach(user->LOGGER.info("Este es el usuario"
				+ "Insertado por el metodo transactional" + user));

	}
	
		
	@Override
	public void run(String... args) {
		//ejemplosAnteriores();
		saveUserDatabase();
		getInformationJpqlUser();
		saveWithErrorTransactional();
		
	}
	
	private void ejemplosAnteriores() {
		componentDependency.saludar();
		myBean.print();
		myBeanWithDependency.printWithDependency();
		LOGGER.info("Este es un Bean con Properties: " + myBeanWithProperties.Properties());
		LOGGER.info("Este es un Pojo: " + userPojo.getName() + " - " + userPojo.getEmail());
		
	}
}
