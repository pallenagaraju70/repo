package com.example.demo.Rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Service.UserManagingService;
import com.example.demo.bindings.UnlockForm;

@RestController
public class UnlockPage {

	@Autowired
	private UserManagingService service;
	
	@PostMapping("/UnLockAccount")
	public String UnlockAccount(@RequestBody UnlockForm unlock) {
		
		
		return service.UnlockAccount(unlock);
	}
}
