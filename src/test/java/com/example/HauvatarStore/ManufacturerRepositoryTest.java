package com.example.HauvatarStore;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.example.HauvatarStore.domain.Manufacturer;
import com.example.HauvatarStore.domain.ManufacturerRepository;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class ManufacturerRepositoryTest {

	@Autowired
	private ManufacturerRepository mrepository;

	@Test
	public void createManufacturer() {
		Manufacturer manufacturer = new Manufacturer("Risteilyttäjä");
		mrepository.save(manufacturer);

		assertThat(manufacturer.getManufacturerId()).isNotNull();
	}

}
