package com.example.HauvatarStore.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface ManufacturerRepository extends CrudRepository <Manufacturer, Long> {
	List<Manufacturer> findByName(String manufacturerName);
}
