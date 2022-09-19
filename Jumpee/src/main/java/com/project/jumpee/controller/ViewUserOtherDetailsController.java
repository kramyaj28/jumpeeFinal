package com.project.jumpee.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;
import com.project.jumpee.exception.View;
import com.project.jumpee.model.OtherDetails;
import com.project.jumpee.service.ViewUserOtherDetailsService;

@RestController
@RequestMapping("/api/auth")
public class ViewUserOtherDetailsController {

	@Autowired
	private ViewUserOtherDetailsService viewUserOtherDetailsService;
	
	@GetMapping("view-other-details")
	@JsonView(View.Base.class)
	public List<OtherDetails> viewOtherDetails () {
		return viewUserOtherDetailsService.getUserDetails();
	}

}
