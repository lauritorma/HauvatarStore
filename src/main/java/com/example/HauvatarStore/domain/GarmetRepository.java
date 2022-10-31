package com.example.HauvatarStore.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface GarmetRepository extends CrudRepository<Garmet, Long> {
	List<Garmet> findByName(String name);
}
