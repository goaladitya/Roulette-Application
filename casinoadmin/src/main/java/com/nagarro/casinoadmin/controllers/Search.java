package com.nagarro.casinoadmin.controllers;

public class Search {
	
	private String name;
	private Long contact;
	private String email;

	public Search(String name, Long contact, String email) {
		super();
		this.name = name;
		this.contact = contact;
		this.email = email;
	}
	
	public Search() {
		super();
	}

	public String getName() {
		return name;
	}

	public Long getContact() {
		return contact;
	}

	public String getEmail() {
		return email;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setContact(Long contact) {
		this.contact = contact;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}

}
