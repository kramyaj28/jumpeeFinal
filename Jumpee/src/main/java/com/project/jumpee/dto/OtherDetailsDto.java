package com.project.jumpee.dto;

import javax.validation.constraints.Pattern;

public class OtherDetailsDto {

	private String address1;
	private String address2;
	private String address3;
	private String contactPerson;

	@Pattern (regexp = "^((\\+63930)|(\\+63895)|(\\+63969)|(\\+63896)|(\\+63897)|(\\+63898)|(\\+63991)|(\\+63992)|(\\+63993)|(\\+63994)|(\\+63907)|(\\+63909)|(\\+63910)|(\\+63908)|(\\+63918)|(\\+63919)|(\\+63905)|(\\+63906)|(\\+63915)|(\\+63916)|(\\+63912)|(\\+63930)|(\\+63938)|(\\+63920)|(\\+63921)|(\\+63928)|(\\+63917)|(\\+63926)|(\\+63927)|(\\+63935)|(\\+63946)|(\\+63948)|(\\+63950)|(\\+63929)|(\\+63939)|(\\+63946)|(\\+63936)|(\\+63937)|(\\+63945)|(\\+63953)|(\\+63947)|(\\+63949)|(\\+63951)|(\\+63954)|(\\+63955)|(\\+63956)|(\\+63965)|(\\+63961)|(\\+63998)|(\\+63999)|(\\+63966)|(\\+63967)|(\\+63975)|(\\+63976)|(\\+63977)|(\\+63978)|(\\+63979)|(\\+63995)|(\\+63996)|(\\+63997)|(\\+63817)|(\\+639173)|(\\+639175)|(\\+639176)|(\\+63922)|(\\+63923)|(\\+63924)|(\\+63925)|(\\+639178)|(\\+639253)|(\\+639255)|(\\+63931)|(\\+63932)|(\\+63933)|(\\+63934)|(\\+639256)|(\\+639257)|(\\+639258)|(\\+63940)|(\\+63941)|(\\+63942)|(\\+63943)|(\\+63973)|(\\+63974))([0-9]{7})$",
			message = "Invalid mobile number. Please start with the country code +63. Example: +639123456789")
	private String contactPersonNumber;
	public OtherDetailsDto(String address1, String address2, String address3, String contactPerson,
			String contactPersonNumber) {
		super();
		this.address1 = address1;
		this.address2 = address2;
		this.address3 = address3;
		this.contactPerson = contactPerson;
		this.contactPersonNumber = contactPersonNumber;
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



}
