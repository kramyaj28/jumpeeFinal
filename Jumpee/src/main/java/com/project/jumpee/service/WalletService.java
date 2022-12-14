package com.project.jumpee.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.jumpee.exception.LoginFirstException;
import com.project.jumpee.model.User;
import com.project.jumpee.model.Wallet;
import com.project.jumpee.repository.UserRepository;
import com.project.jumpee.repository.WalletRepository;

@Service
public class WalletService {

	@Autowired
	private WalletRepository walletRepository;

	@Autowired
	private UserRepository userRepository;

	public Wallet addWalletBalance(Wallet request) {

		if(!userRepository.existsByStatus(1)) {
			throw new LoginFirstException("");
		}

		User user = userRepository.getUserByStatus(1);
		Wallet wallet = walletRepository.findByUserId(user.getId());
		Wallet currentBalanceWallet = walletRepository.getWalletBalance(user.getId());
		wallet.setWalletBalance(request.getWalletBalance()+currentBalanceWallet.getWalletBalance());
		walletRepository.save(wallet);

		return wallet;
	}

	public Wallet viewWalletBalance (Wallet request) {

		if(!userRepository.existsByStatus(1)) {
			throw new LoginFirstException("");
		}

		User user = userRepository.getUserByStatus(1);
		Wallet wallet = walletRepository.getWalletBalance(user.getId());
		return wallet;	
	}

}
