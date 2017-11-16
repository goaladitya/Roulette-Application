package com.nagarro.casinoadmin.models;

//package com.nagarro.CasinoAdmin.models;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name = "users")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID")
	private Long id;

	@Column(name = "NAME")
	@NotEmpty(message = "pls enter name")
	private String name;

	@Column(name = "DOB")
	private Date dob;

	@Column(name = "CONTACT")
	@NotNull
	private Long contact;

	@Column(name = "EMAIL")
	@NotEmpty(message = "pls enter email")
	@Email
	private String email;

	@Column(name = "BALANCE")
	private Long balance;
	
	@Column(name = "BLOCKED_AMOUNT")
	private Long blocked_amount;
	

	public User() {
		super();
		this.balance = new Long(500);
		this.blocked_amount = new Long(0);
	}

	public User(String name, Date dob, Long contact, String email) {
		super();
		this.name = name;
		this.dob = dob;
		this.contact = contact;
		this.email = email;
		this.balance = new Long(500);
		this.blocked_amount = new Long(0);
	}

	public User(Long id, String name, Date dob, Long contact, String email) {
		super();
		this.id = id;
		this.name = name;
		this.dob = dob;
		this.contact = contact;
		this.email = email;
		this.balance = new Long(500);
		this.blocked_amount = new Long(0);
	}

	public Long getBlocked_amount() {
		return blocked_amount;
	}

	public void setBlocked_amount(Long blocked_amount) {
		this.blocked_amount = blocked_amount;
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

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public Long getContact() {
		return contact;
	}

	public void setContact(Long contact) {
		this.contact = contact;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Long getBalance() {
		return balance;
	}

	public void setBalance(Long balance) {
		this.balance = balance;
	}

}
