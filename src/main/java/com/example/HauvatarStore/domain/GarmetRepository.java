package com.example.HauvatarStore.domain;

import java.util.HashMap;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface GarmetRepository extends CrudRepository<Garmet, Long> {
    List<Garmet> findByName(String name);

    List<Garmet> findByManufacturer(String manufacturer);
    
    @Query(value="SELECT Manufacturer.Manufacturer_Name, COUNT(Garmet.ID) AS NumberOfGarmets FROM Garmet LEFT JOIN Manufacturer on Garmet.Manufacturer=Manufacturer.manufacturer_name GROUP BY Manufacturer_name;",
			nativeQuery=true)
    List<Object> getCountByManufacturer();
}
