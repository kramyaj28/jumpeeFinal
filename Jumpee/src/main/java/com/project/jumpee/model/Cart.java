package com.project.jumpee.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonView;
import com.project.jumpee.exception.View;

@Entity
@Table(name = "cart")
public class Cart {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@JsonView(View.Base.class)
	private long id;
	
	private long userId;
	
	@JsonView(View.Base.class)
	private long productId;
	
	private byte paymentStatus;
	private byte checkOutStatus;
	
	@JsonView(View.Base.class)
	private int quantity;
	
	@JsonView(View.Base.class)
	private float totalAmount;
	
	public Cart(long userId, long productId, byte paymentStatus, byte checkOutStatus, int quantity, float totalAmount) {
		super();
		this.userId = userId;
		this.productId = productId;
		this.paymentStatus = paymentStatus;
		this.paymentStatus = paymentStatus;
		this.quantity = quantity;
		this.totalAmount = totalAmount;
	}

	public Cart() {}
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public byte getPaymentStatus() {
		return paymentStatus;
	}
	public void setPaymentStatus(byte status) {
		this.paymentStatus = status;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public float getTotalAmount() {
		return totalAmount;
	}
	public void setTotalAmount(float totalAmount) {
		this.totalAmount = totalAmount;
	}

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public long getProductId() {
		return productId;
	}

	public void setProductId(long productId) {
		this.productId = productId;
	}

	public byte getCheckOutStatus() {
		return checkOutStatus;
	}

	public void setCheckOutStatus(byte checkOutStatus) {
		this.checkOutStatus = checkOutStatus;
	}
	
	
}
