package com.project.jumpee.dto;

public class LoginDto {
	private String username;
	private String password;
	
	public String getUsername() {
		return username;
	}
	public String getPassword() {
		return password;
	}
	public LoginDto(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}
	
}
