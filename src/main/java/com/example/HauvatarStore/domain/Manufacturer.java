package com.example.HauvatarStore.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Manufacturer {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long manufacturerId;
	private String manufacturerName;
	
	
	@JsonIgnore
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "manufacturer")
	private List<Garmet> garmets;
	
	public Manufacturer() {}

	public Long getManufacturerId() {
		return manufacturerId;
	}

	public void setManufacturerId(Long manufacturerId) {
		this.manufacturerId = manufacturerId;
	}

	public String getManufacturerName() {
		return manufacturerName;
	}

	public void setManufacturerName(String manufacturerName) {
		this.manufacturerName = manufacturerName;
	}

	public List<Garmet> getGarmets() {
		return garmets;
	}

	public void setGarmets(List<Garmet> garmets) {
		this.garmets = garmets;
	}
	
	
}