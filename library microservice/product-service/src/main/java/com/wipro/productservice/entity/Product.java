package com.wipro.productservice.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Product {
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return "Product [name=" + name + ", price=" + price + "]";
	}
	@Id
	private String name;
	private Double price;

}
