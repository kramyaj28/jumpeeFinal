package com.project.jumpee.service;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.jumpee.exception.InsufficientBalanceException;
import com.project.jumpee.exception.LoginFirstException;
import com.project.jumpee.model.Cart;
import com.project.jumpee.model.Orders;
import com.project.jumpee.model.OtherDetails;
import com.project.jumpee.model.Product;
import com.project.jumpee.model.User;
import com.project.jumpee.model.Wallet;
import com.project.jumpee.repository.CartRepository;
import com.project.jumpee.repository.OrderRepository;
import com.project.jumpee.repository.OtherDetailsRepository;
import com.project.jumpee.repository.ProductRepository;
import com.project.jumpee.repository.UserRepository;
import com.project.jumpee.repository.WalletRepository;

@Service
public class CheckoutService {

	@Autowired
	private ProductRepository productRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private CartRepository cartRepository;
	
	@Autowired
	private OrderRepository orderRepository;
	
	@Autowired
	private WalletRepository walletRepository;
	
	@Autowired
	private OtherDetailsRepository otherDetailsRepository;
	
	public Cart checkout(Orders request) {
		
		if(!userRepository.existsByStatus(1)) {
			throw new LoginFirstException("");
		}
		
//		if(cartRepository.findByCheckOutStatus(0))
		User user = userRepository.getUserByStatus(1);
		Cart cart = cartRepository.findById(request.getOrderId());
		OtherDetails addressDetails = otherDetailsRepository.findByUserId(user.getId());
		updateWallet(user.getId(), cart.getTotalAmount());
		request.setCartId(cart.getId());
		request.setUserId(user.getId());
		request.setTotalAmount(cart.getTotalAmount());
		request.setTimeOrderPlaced(LocalDateTime.now());
		request.setFirstName(user.getFirstName());
		request.setLastName(user.getLastName());
		request.setAddress(addressDetails.getAddress1());
//		checkIfPaid(request.getCartId());
		orderRepository.save(request);
		updatePaidStatus(request.getCartId());
		updateCheckOutStatus(request.getCartId());
		updateQuantity(cart.getProductId(), cart.getQuantity());
		return cart;
	}
	
	public void updateWallet(long userId, float totalAmount) {
		Wallet wallet = walletRepository.findByUserId(userId);
		float currentWalletBalance = wallet.getWalletBalance();
		float updatedWalletBalance = currentWalletBalance - totalAmount;
		
		if(currentWalletBalance < totalAmount) {
			throw new InsufficientBalanceException("");
		}
		
		wallet.setWalletBalance(updatedWalletBalance);
		walletRepository.save(wallet);
	}
	
	public void updatePaidStatus(long id) {
		Cart cart = cartRepository.findById(id);
		cart.setPaymentStatus((byte) 1);
		cartRepository.save(cart);
	}
	
	public void updateCheckOutStatus(long id) {
		Cart cart = cartRepository.findById(id);
		cart.setCheckOutStatus((byte) 1);
		cartRepository.save(cart);
	}
	
	public void updateQuantity(long productId, int quantity) {
		Product product = productRepository.findById(productId);
		int currentQuantity = product.getQuantity();
		int updatedQuantity = currentQuantity - quantity;
		product.setQuantity(updatedQuantity);
		productRepository.save(product);
	}

}
