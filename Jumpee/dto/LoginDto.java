package com.project.jumpee.dto;

import java.util.Objects;

public class LoginDto {
	private String usernameOrEmail;
	private String password;
	public String getUsernameOrEmail() {
		return usernameOrEmail;
	}
	public void setUsernameOrEmail(String usernameOrEmail) {
		this.usernameOrEmail = usernameOrEmail;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public LoginDto(String usernameOrEmail, String password) {
		super();
		this.usernameOrEmail = usernameOrEmail;
		this.password = password;
	}
	@Override
	public String toString() {
		return "LoginDto [usernameOrEmail=" + usernameOrEmail + ", password=" + password + "]";
	}
	@Override
	public int hashCode() {
		return Objects.hash(password, usernameOrEmail);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		LoginDto other = (LoginDto) obj;
		return Objects.equals(password, other.password) && Objects.equals(usernameOrEmail, other.usernameOrEmail);
	}
}
