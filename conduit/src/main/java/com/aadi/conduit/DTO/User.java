package com.aadi.conduit.DTO;

import com.fasterxml.jackson.annotation.JsonProperty;

public class User{

	@JsonProperty("password")
	private String password;

	@JsonProperty("email")
	private String email;

	@JsonProperty("username")
	private String username;

	public String getPassword(){
		return password;
	}

	public String getEmail(){
		return email;
	}

	public String getUsername(){
		return username;
	}
}