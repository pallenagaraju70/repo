package com.example.demo.Rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Service.UserManagingService;

@RestController
public class ForgetPassword {

	@Autowired
	private UserManagingService service;
	
	@GetMapping("/ForgetPassword/{Email}")
	public String forgetpassword(@PathVariable ("Email") String email) {
		
		return service.Forgetpassword(email);
	}
}
