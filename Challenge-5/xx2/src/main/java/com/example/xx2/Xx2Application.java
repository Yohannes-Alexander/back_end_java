package com.example.xx2;


import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class Xx2Application {
	
	public static void main(String[] args) {
		SpringApplication.run(Xx2Application.class, args);
		// HomeController homeController = SpringApplication.run(Xx2Application.class, args).getBean(HomeController.class);
		// homeController.home();
		// MerchantController merchantController = SpringApplication.run(Xx2Application.class, args).getBean(MerchantController.class);
		// merchantController.updateMerchant();
		// UserController userController = SpringApplication.run(Xx2Application.class, args).getBean(UserController.class);
		// userController.deleteUser();
		
	}
	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}

}
