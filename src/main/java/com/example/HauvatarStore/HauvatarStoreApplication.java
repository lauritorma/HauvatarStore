package com.example.HauvatarStore;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.HauvatarStore.domain.Garmet;
import com.example.HauvatarStore.domain.GarmetRepository;
import com.example.HauvatarStore.domain.Manufacturer;
import com.example.HauvatarStore.domain.ManufacturerRepository;


@SpringBootApplication
public class HauvatarStoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(HauvatarStoreApplication.class, args);
	}
}