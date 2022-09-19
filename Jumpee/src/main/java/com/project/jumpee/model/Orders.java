package com.project.jumpee.model;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Orders {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long orderId;
	
	private long cartId;
	private long userId;
	private String firstName;
	private String lastName;
	private String address;
	
	private LocalDateTime timeOrderPlaced;
	private float totalAmount;

	
	

	public Orders(long cartId, long userId, String firstName, String lastName, String address,
			LocalDateTime timeOrderPlaced, float totalAmount) {
		super();
		this.cartId = cartId;
		this.userId = userId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
		this.timeOrderPlaced = timeOrderPlaced;
		this.totalAmount = totalAmount;
	}


	public Orders () {}


	public long getOrderId() {
		return orderId;
	}

	public void setOrderId(long orderId) {
		this.orderId = orderId;
	}

	public LocalDateTime getTimeOrderPlaced() {
		return timeOrderPlaced;
	}

	public void setTimeOrderPlaced(LocalDateTime timeOrderPlaced) {
		this.timeOrderPlaced = timeOrderPlaced;
	}

	public float getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(float totalAmount) {
		this.totalAmount = totalAmount;
	}

	public long getCartId() {
		return cartId;
	}


	public void setCartId(long cartId) {
		this.cartId = cartId;
	}


	public long getUserId() {
		return userId;
	}


	public void setUserId(long userId) {
		this.userId = userId;
	}


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


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}
	
	
	
	
}
