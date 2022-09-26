package com.project.jumpee.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;
import com.project.jumpee.dto.AddressDto;
import com.project.jumpee.exception.View;
import com.project.jumpee.model.Address;
import com.project.jumpee.model.User;
import com.project.jumpee.service.AccountDetailsService;

@RestController
@RequestMapping("/api/auth")
public class AccountDetailsController {

    @Autowired
	private AccountDetailsService accountDetailsService;

	@GetMapping("/view-details")
	@JsonView(View.Base.class)
    public ResponseEntity<User> getUserDetails(){
        return new ResponseEntity<User>(accountDetailsService.viewAccountDetails(), HttpStatus.OK);
    }
	
	@JsonView(View.Base.class)
	@PostMapping("/address")
	public ResponseEntity<Address> saveDetailString (@RequestBody Address request) {
		return new ResponseEntity<Address>(accountDetailsService.addAddress(request), HttpStatus.CREATED);
	}
	
	@JsonView(View.Base.class)
	@GetMapping("/view-address")
	public List<Address> viewAddress(){
	return accountDetailsService.viewAddress();
	}
	
	@JsonView(View.Base.class)
	@PutMapping("/edit-address")
	public ResponseEntity<Address> updateAddress(@RequestBody AddressDto request) {
		return new ResponseEntity<Address>(accountDetailsService.editAddress(request), HttpStatus.OK);
	}
	
	@DeleteMapping("/delete-address/{id}")
	public ResponseEntity<String> deleteAddress (@PathVariable("id") long addressId){
		accountDetailsService.deleteAddress(addressId);
		return new ResponseEntity<String>("Deleted.", HttpStatus.OK);
	}
	
	@JsonView(View.Base.class)
	@PutMapping("/default-address/{id}")
	public ResponseEntity<String> setDefaultAddress(@PathVariable ("id") long addressId) {
		accountDetailsService.setDefaultAddress(addressId);
		return new ResponseEntity<String>("Default address has been set.", HttpStatus.OK);
		
	}
	
	
}