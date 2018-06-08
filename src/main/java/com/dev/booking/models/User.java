package com.dev.booking.models;

import java.sql.Date;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;

@Document
public class User {

	@Id
	@JsonSerialize(using = ToStringSerializer.class)
	private ObjectId id;
	private String login;
	private String firstName;
	private String lastName;
	private String password;
	private String email;
	private Role role;
	
	@CreatedDate
	private Date createdDate;
	
	@LastModifiedDate
	private Date modifiedDate;

	public User() {
		
	}
	
	public User(ObjectId id, String login, String firstName, String lastName, String password,
			String email,Role role) {
		
		this.id = id;
		this.login = login;
		this.firstName = firstName;
		this.lastName = lastName;
		this.password = password;
		this.email = email;
		this.role = role;
	}

	public ObjectId getId() {
		return id;
	}

	public void setId(ObjectId id) {
		this.id = id;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}
	
	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public Date getModifiedDate() {
		return modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		this.modifiedDate = modifiedDate;
	}
	
}
