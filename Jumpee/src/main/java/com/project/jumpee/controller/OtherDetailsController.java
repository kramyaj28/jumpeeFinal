package com.project.jumpee.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;
import com.project.jumpee.exception.View;
import com.project.jumpee.model.OtherDetails;
import com.project.jumpee.service.OtherDetailsService;

@RestController
@RequestMapping("/api/auth")
public class OtherDetailsController {

	@Autowired
	private OtherDetailsService otherDetailsService;
	
	@PostMapping("/other-details")
	@JsonView(View.Base.class)
	public ResponseEntity<OtherDetails> saveDetailString (@Valid @RequestBody OtherDetails request) {
		return new ResponseEntity<OtherDetails>(otherDetailsService.saveDetails(request),HttpStatus.CREATED);
	}
	
}
