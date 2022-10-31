package com.example.HauvatarStore;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

// import com.example.HauvatarStore.domain.Tuote;
// import com.example.HauvatarStore.domain.TuoteRepository;
// import com.example.HauvatarStore.domain.Category;
// import com.example.HauvatarStore.domain.CategoryRepository;
// import com.example.HauvatarStore.domain.Useri;
// import com.example.HauvatarStore.domain.UserRepository;

@SpringBootApplication
public class HauvatarStoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(HauvatarStoreApplication.class, args);
	}
	
	//@Bean
	//public CommandLineRunner bookDemo(TuoteRepository tRepository, CategoryRepository categoryRepository, UserRepository urepository) {
		//return (args) -> {
			// categoryRepository.save(new Category("1"));
			// categoryRepository.save(new Category("2"));
			
			//tRepository.save(new Tuote("1", categoryRepository.findByName("").get(0)));
			//tRepository.save(new Tuote("2", "2", categoryRepository.findByName("").get(0)));
		
			//Useri user1 = new Useri("user", "$2a$06$3jYRJrg0ghaaypjZ/.g4SethoeA51ph3UD4kZi9oPkeMTpjKU5uo6", "USER");
			//Useri user2 = new Useri("admin", "$2a$10$0MMwY.IQqpsVc1jC8u7IJ.2rT8b0Cd3b3sfIBGV2zfgnPGtT4r0.C", "ADMIN");
			//urepository.save(user1);
			//urepository.save(user2);
		//};
	//}

}