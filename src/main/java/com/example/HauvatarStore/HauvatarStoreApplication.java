package com.example.HauvatarStore;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.HauvatarStore.domain.Garmet;
import com.example.HauvatarStore.domain.GarmetRepository;
import com.example.HauvatarStore.domain.Manufacturer;
import com.example.HauvatarStore.domain.ManufacturerRepository;

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
	@Bean
	public CommandLineRunner vaateDemo(GarmetRepository gRepository, ManufacturerRepository mrepository) {
		return (args) -> {
			gRepository.save(new Garmet("Koiruliinin villapaituliini", "Koiran vaatteet", 20, "K9 Clothing"));
			gRepository.save(new Garmet("Koiruliinin sadetakkinen", "Koiran vaatteet", 25, "K9 Clothing"));
			gRepository.save(new Garmet("Kissuliinin sadetakkuli", "Kissan vaatteet", 15, "Kitty Clothing"));
			gRepository.save(new Garmet("Kisulin töppöset", "Kissan vaatteet", 5, "Kitty Clothing"));
		
			mrepository.save(new Manufacturer("Mustin mirri"));
			mrepository.save(new Manufacturer("Kylmä koira"));
			mrepository.save(new Manufacturer("Dogster"));
			mrepository.save(new Manufacturer("Murr & Miau"));
			mrepository.save(new Manufacturer("Hedgehog Clothing co."));
		
		
		};
	}
	//@Bean
	//public CommandLineRunner TuoteDemo(TuoteRepository tRepository, CategoryRepository categoryRepository, UserRepository urepository) {
		//return (args) -> {
			// categoryRepository.save(new Category("Koiran Vaatteet"));
			// categoryRepository.save(new Category("Kissan Vaatteet"));
			
			//tRepository.save(new Tuote("Koiran Villapaita", categoryRepository.findByName("Koiran Vaatteet").get(0), "15.99", "HauHau"));
			//tRepository.save(new Tuote("Koiran Sadetakki", categoryRepository.findByName("Koiran Vaatteet").get(0), "29.99", "HauHau"));
		
			//Useri user1 = new Useri("user", "$2a$06$3jYRJrg0ghaaypjZ/.g4SethoeA51ph3UD4kZi9oPkeMTpjKU5uo6", "USER");
			//Useri user2 = new Useri("admin", "$2a$10$0MMwY.IQqpsVc1jC8u7IJ.2rT8b0Cd3b3sfIBGV2zfgnPGtT4r0.C", "ADMIN");
			//urepository.save(user1);
			//urepository.save(user2);
		//};
	//}

}