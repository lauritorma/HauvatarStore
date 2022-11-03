package com.example.HauvatarStore.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.PositiveOrZero;

@Entity
public class Garmet {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank(message = "Kenttä ei voi olla tyhjä")
	private String name;
	@NotBlank(message = "Kenttä ei voi olla tyhjä")
	private String type;
	@PositiveOrZero
	@Digits(integer=6, fraction=2, message = "Hinta pitää olla 2 desimaalin tarkkuudella")
	private double price;
	@NotBlank(message = "Kenttä ei voi olla tyhjä")
	private String manufacturer;

	public Garmet() {
	}

	public Garmet(String name, String type, double price, String manufacturer) {
		super();
		this.name = name;
		this.type = type;
		this.price = price;
		this.manufacturer = manufacturer;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getManufacturer() {
		return manufacturer;
	}

	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}

	@Override
	public String toString() {
		return "Garmet [id=" + id + ", name=" + name + ", type=" + type + ", price=" + price + ", manufacturer="
				+ manufacturer + "]";
	}

}
