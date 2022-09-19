package com.project.jumpee.dto;

import javax.persistence.Transient;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

public class ChangeResetPasswordDto {
	
	private String email;
	
	@NotBlank (message = "This field must not be blank.")
	@NotNull(message="Please key in your password.")
	@Pattern(regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#&()–[{}]:;',?/*~$^+=<>]).{8,20}$",
			message = "Must contain at least one (number, lowercase, uppercase, special character)."
					+ " Must contain a length of at least 8 characters and a maximum of 20 characters.")
	private String password;
	
	@Transient
	private String currentPassword;
	
	public String getCurrentPassword() {
		return currentPassword;
	}

	public void setCurrentPassword(String currentPassword) {
		this.currentPassword = currentPassword;
	}

	@Transient
	private String confirmPassword;
	
	public ChangeResetPasswordDto() {}

	public ChangeResetPasswordDto(String password) {
		super();
		this.password = password;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getConfirmPassword() {
		return confirmPassword;
	}

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	

	
}