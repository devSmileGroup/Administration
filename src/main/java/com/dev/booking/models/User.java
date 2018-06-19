package com.dev.booking.models;


import java.util.Date;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;

import lombok.Data;

@Data
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

}
