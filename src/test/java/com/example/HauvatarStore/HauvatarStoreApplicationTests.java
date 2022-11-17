package com.example.HauvatarStore;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.example.HauvatarStore.web.VaateRestController;

@ExtendWith(SpringExtension.class)
@SpringBootTest
class HauvatarStoreApplicationTests {

	@Autowired
	private VaateRestController vcontroller;

	@Test
	void contextLoads() throws Exception {
		assertThat(vcontroller).isNotNull();
	}
}
