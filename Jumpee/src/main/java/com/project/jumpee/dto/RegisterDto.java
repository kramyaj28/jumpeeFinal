package com.project.jumpee.dto;

import javax.persistence.Transient;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

public class RegisterDto {
	
	@NotBlank (message="First name must not be blank.")
	private String firstName;
	
	@NotBlank (message="Last name must not be blank.")
	@NotEmpty (message="Please key in your last name.")
	private String lastName;
	
	@Email(message="Please key in a valid email.")
	private String email;
	
	@Pattern (regexp = "^((\\+63930)|(\\+63895)|(\\+63969)|(\\+63896)|(\\+63897)|(\\+63898)|(\\+63991)|(\\+63992)|(\\+63993)|(\\+63994)|(\\+63907)|(\\+63909)|(\\+63910)|(\\+63908)|(\\+63918)|(\\+63919)|(\\+63905)|(\\+63906)|(\\+63915)|(\\+63916)|(\\+63912)|(\\+63930)|(\\+63938)|(\\+63920)|(\\+63921)|(\\+63928)|(\\+63917)|(\\+63926)|(\\+63927)|(\\+63935)|(\\+63946)|(\\+63948)|(\\+63950)|(\\+63929)|(\\+63939)|(\\+63946)|(\\+63936)|(\\+63937)|(\\+63945)|(\\+63953)|(\\+63947)|(\\+63949)|(\\+63951)|(\\+63954)|(\\+63955)|(\\+63956)|(\\+63965)|(\\+63961)|(\\+63998)|(\\+63999)|(\\+63966)|(\\+63967)|(\\+63975)|(\\+63976)|(\\+63977)|(\\+63978)|(\\+63979)|(\\+63995)|(\\+63996)|(\\+63997)|(\\+63817)|(\\+639173)|(\\+639175)|(\\+639176)|(\\+63922)|(\\+63923)|(\\+63924)|(\\+63925)|(\\+639178)|(\\+639253)|(\\+639255)|(\\+63931)|(\\+63932)|(\\+63933)|(\\+63934)|(\\+639256)|(\\+639257)|(\\+639258)|(\\+63940)|(\\+63941)|(\\+63942)|(\\+63943)|(\\+63973)|(\\+63974))([0-9]{7})$",
			message = "Invalid mobile number. Please start with the country code +63. Example: +639123456789")
	private String mobileNumber;
	
	@NotBlank (message = "This field must not be blank.")
	@NotNull(message="Please key in your password.")
	@Pattern(regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#&()–[{}]:;',?/*~$^+=<>]).{8,20}$",
			message = "Must contain at least one (number, lowercase, uppercase, special character)."
					+ " Must contain a length of at least 8 characters and a maximum of 20 characters.")
	
	private String password;
	
	@Transient
	private String confirmPassword;
	
	public RegisterDto() {}
	
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	
	public String getConfirmPassword() {
		return confirmPassword;
	}

	public RegisterDto(String firstName, String lastName, String email, String mobileNumber, String password) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.mobileNumber = mobileNumber;
		this.password = password;
	}

	
}