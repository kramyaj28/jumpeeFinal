package com.project.jumpee.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.jumpee.dto.OtherDetailsDto;
import com.project.jumpee.service.DeleteOtherDetailsService;

@RestController
@RequestMapping("/api/auth")
public class DeleteAccountDetailsController {

    @Autowired
	private DeleteOtherDetailsService deleteotherdetailsService;

	@DeleteMapping("/delete-details")
    public ResponseEntity<String> editUserDetails(@RequestBody OtherDetailsDto request){
        return new ResponseEntity<String>(deleteotherdetailsService.deleteOtherDetails(request), HttpStatus.OK);
    }
}