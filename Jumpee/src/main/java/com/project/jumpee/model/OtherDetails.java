package com.project.jumpee.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonView;
import com.project.jumpee.exception.View;

@Entity
public class OtherDetails {

	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne
	@JoinColumn(name = "user_id", referencedColumnName = "id")
	@JsonView(View.Base.class)
	private User user;
	
	@JsonView(View.Base.class)
	private String address1;
	
	@JsonView(View.Base.class)
	private String address2;
	
	@JsonView(View.Base.class)
	private String address3;
	
	@JsonView(View.Base.class)
	private String contactPerson;
	
	@JsonView(View.Base.class)
	private String contactPersonNumber;
	
	
	public OtherDetails(String address, String contactPerson, String contactPersonNumber, User user) {
		super();
		this.address1 = address;
		this.contactPerson = contactPerson;
		this.contactPersonNumber = contactPersonNumber;
		this.user = user;
	}

	public OtherDetails() {}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getAddress1() {
		return address1;
	}
	public void setAddress1(String address1) {
		this.address1 = address1;
	}
	
	public String getAddress2() {
		return address2;
	}
	public void setAddress2(String address2) {
		this.address2 = address2;
	}
	
	
	public String getAddress3() {
		return address3;
	}
	public void setAddress3(String address3) {
		this.address3 = address3;
	}
	
	public String getContactPerson() {
		return contactPerson;
	}
	public void setContactPerson(String contactPerson) {
		this.contactPerson = contactPerson;
	}
	public String getContactPersonNumber() {
		return contactPersonNumber;
	}
	public void setContactPersonNumber(String contactPersonNumber) {
		this.contactPersonNumber = contactPersonNumber;
	}
	
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}
