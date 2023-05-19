package com.example.model;

import java.util.List;

import javax.annotation.Generated;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "UsersTab")
public class Users {

	@Id
	@Field(name = "_id")
	@JsonIgnore          
	@Generated(value = { "increment" })
	private String id;
	@Field(name = "uName")
	private String name;
	@Field(name = "uEmail")
	private String email;
	@Field(name = "uPassword")
	private String pwd;
	
	@Field(name = "roles")
	private List<String> roles;
}
