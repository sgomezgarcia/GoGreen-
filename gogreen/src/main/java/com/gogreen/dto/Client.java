package com.gogreen.dto;

import java.io.Serializable;

public class Client implements Serializable{   
    private int id;
    private String name;
    private String surname;
    private String password;
    private double balance;

    public Client() {
    }

	public Client(int id) {
		this.id = id;
	}

	public Client(int id, String name, String surname, String password, double balance) {
		this.id = id;
		this.name = name;
		this.surname = surname;
		this.password = password;
		this.balance = balance;
	}

	public Client(String name, String surname, String matr, String password, double balance) {
		super();
		this.name = name;
		this.surname = surname;
		this.password = password;
		this.balance = balance;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}


	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	@Override
	public String toString() {
		return "Client [id=" + id + ", name=" + name + ", surname=" + surname +  "balance=" + balance + "]";
	}



}
