package com.project.jumpee.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;
import com.project.jumpee.dto.OtherDetailsDto;
import com.project.jumpee.exception.View;
import com.project.jumpee.model.OtherDetails;
import com.project.jumpee.service.UpdateOtherDetailsService;

@RestController
@RequestMapping("/api/auth")
public class UpdateAccountDetailsController {

    @Autowired
	private UpdateOtherDetailsService updateOtherDetailsService;

	@PutMapping("/edit-details")
	@JsonView(View.Base.class)
    public ResponseEntity<OtherDetails> editUserDetails(@Valid @RequestBody OtherDetailsDto request){
        return new ResponseEntity<OtherDetails>(updateOtherDetailsService.updateOtherDetails(request), HttpStatus.OK);
    }
}