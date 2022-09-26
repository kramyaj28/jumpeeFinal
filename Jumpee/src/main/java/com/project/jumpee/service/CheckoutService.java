package com.project.jumpee.service;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.jumpee.exception.InsufficientBalanceException;
import com.project.jumpee.exception.LoginFirstException;
import com.project.jumpee.model.Cart;
import com.project.jumpee.model.Order;
import com.project.jumpee.model.Address;
import com.project.jumpee.model.Product;
import com.project.jumpee.model.User;
import com.project.jumpee.model.Wallet;
import com.project.jumpee.repository.CartRepository;
import com.project.jumpee.repository.OrderRepository;
import com.project.jumpee.repository.AddressRepository;
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
	private AddressRepository addressRepository;
	
	public Order checkout(Order request) {
		
		if(!userRepository.existsByStatus(1)) {
			throw new LoginFirstException("");
		}
		
		User user = userRepository.getUserByStatus(1);
		Cart cart = cartRepository.getByCartId(user.getId(), request.getCartId());
		Address address = addressRepository.getAddressId(user.getId());
		Order order = new Order();
		order.setAddress(address.getAddress());
		order.setFirstName(user.getFirstName());
		order.setLastName(user.getLastName());
		order.setAddress(address.getAddress());
		order.setCartId(cart.getId());
		order.setTimeOrderPlaced(LocalDateTime.now());
		order.setTotalAmount(cart.getTotalAmount());
		order.setUserId(cart.getUserId());
		updateWallet(user.getId(), cart.getTotalAmount());
		updatePaidStatus(cart.getId());
		updateCheckOutStatus(cart.getId());
		updateQuantity(cart.getProductId(), cart.getQuantity());
		orderRepository.save(order);
		return order;
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
