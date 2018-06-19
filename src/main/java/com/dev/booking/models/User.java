package com.dev.booking.models;


import java.time.LocalDateTime;
import java.util.Date;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;

import lombok.Data;

@Data
@Document
public class User {

	@Id
	@JsonSerialize(using = ToStringSerializer.class)
	@Field("user_id")
	private ObjectId userid;
	private String login;
	@Field("first_name")
	private String firstName;
	@Field("last_name")
	private String lastName;
	private String password;
	private String email;
	private Role role;
	
	@CreatedDate
	@Field("created_date")
	private LocalDateTime createdDate;
	
	@LastModifiedDate
	@Field("modified_date")
	private LocalDateTime modifiedDate;

}
