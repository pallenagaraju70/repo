package com.example.demo.Rest;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Service.UserManagingService;
import com.example.demo.bindings.UserRegistrationForm;

@RestController
public class UserRegistration {

	@Autowired
	private UserManagingService service;
	
	@GetMapping("/email/{EmailId}")
	public String EmailCheck (@PathVariable("EmailId") String EmailId) {
	
		return service.EmailCheckup(EmailId);
	}
	
	@GetMapping("/Countries")
	public Map<Integer, String> loadcountries(){
		
		return service.loadCountries();
		
	}
	
	@GetMapping("/States/{CountryId}")
	public Map<Integer, String> loadstates(@PathVariable ("CountryId")Integer CountryId){
		
		return service.loadStates(CountryId);
	}
	
	
	@GetMapping("/Cities/{StateId}")
	public Map<Integer, String> loadcities(@PathVariable ("StateId")Integer StateId){
		
		return service.loadCities(StateId);
	}
	
	@PostMapping("/UserRegistration")
	public String UserRegistration(@RequestBody UserRegistrationForm user) {
		
		return service.UserRegisteration(user);
	}
}
