package com.gogreen.dto;

import java.io.Serializable;

public class Product implements Serializable{   
    private int code;
    private String name;
    private Float price;
    private String description;
    private Float saldo;

	public Product(int code) {
		this.code = code;
	}

	public Product(int code, String name, Float price, String description, Float saldo) {
		this.code = code;
		this.name = name;
		this.price = price;
		this.description = description;
		this.saldo = saldo;
	}


	public Product(String name, Float price, String description, Float saldo) {
		super();
		this.name = name;
		this.price = price;
		this.description = description;
		this.saldo = saldo;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Float getPrice() {
		return price;
	}

	public void setPrice(Float price2) {
		this.price = price2;
	}



	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setPhone(String description) {
		this.description = description;
	}
	
	public Float getSaldo() {
		return saldo;
	}

	public void setSaldo(Float saldo) {
		this.saldo = saldo;
	}

	@Override
	public String toString() {
		return "Product [code=" + code + ", name=" + name + ", price=" + price + ", description=" + description + ", saldo=" + saldo + "]";
	}



}
