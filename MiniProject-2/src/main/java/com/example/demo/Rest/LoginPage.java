package com.example.demo.Rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Service.UserManagingService;
import com.example.demo.bindings.LoginFrom;

@RestController
public class LoginPage {
	
	@Autowired
	private UserManagingService service;
	
	@GetMapping("/login")
	public String login(LoginFrom login) {
		
		return service.login(login);
	}

}
