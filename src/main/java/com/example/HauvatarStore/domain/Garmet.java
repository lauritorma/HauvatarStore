package com.example.HauvatarStore.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;

@Entity
@Table(name="garmet")
public class Garmet {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id",nullable=false)
	private Long id;
	
	@NotBlank(message = "Kenttä ei voi olla tyhjä")
	@Column(name="name",nullable=false)
	private String name;
	@NotBlank(message = "Kenttä ei voi olla tyhjä")
	@Column(name="tyyppi",nullable=false)
	private String type;
	@PositiveOrZero(message = "Hinta ei voi olla negatiivinen luku")
	@NotNull(message = "Kenttä ei voi olla tyhjä")
	@Digits(integer=6, fraction=2, message = "Hinta saa olla enintään 6 numeroa ja enintään 2 desimaalin tarkkuudella")
	@Column(name="price",nullable=false)
	private Double price;
	@Column(name="manufacturer",nullable=false)
	private String manufacturer;

	public Garmet() {
	}

	public Garmet(String name, String type, Double price, String manufacturer) {
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

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
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
