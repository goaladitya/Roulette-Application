package com.nagarro.casinoadmin.controllers;

public class Recharge {
	
	private Long id;
	private Long balance;

	public Recharge(Long id, Long balance) {
		super();
		this.id = id;
		this.balance = balance;
	}
	
	public Recharge() {
		super();
	}	

	public Long getId() {
		return id;
	}

	public Long getBalance() {
		return balance;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setBalance(Long balance) {
		this.balance = balance;
	}

}
