package com.aadi.conduit.DTO;

import com.fasterxml.jackson.annotation.JsonProperty;

public class UserSignupDto{

	@JsonProperty("user")
	private User user;

	public User getUser(){
		return user;
	}
}