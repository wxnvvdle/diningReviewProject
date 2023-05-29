package com.example.demo;

import com.example.demo.model.Restaurant;
import com.example.demo.model.User;
import com.example.demo.repositories.UserRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CodecademyPortfolioProjectApplication {

	@Autowired
	private UserRepository userRepository;

	public static void main(String[] args) {
		SpringApplication.run(CodecademyPortfolioProjectApplication.class, args);

	}


	@PostConstruct
	public void insertDb(){

		User idiot = new User("Gleb", "Odessa" , "Massachusetts", 3221 , true, false, true);
		userRepository.save(idiot);
	}
}
