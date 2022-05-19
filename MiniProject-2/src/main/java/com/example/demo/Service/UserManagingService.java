package com.example.demo.Service;

import java.util.Map;

import com.example.demo.bindings.LoginFrom;
import com.example.demo.bindings.UnlockForm;
import com.example.demo.bindings.UserRegistrationForm;

public interface UserManagingService {

	public String login(LoginFrom login);
	
	public String EmailCheckup(String email);
	
	public Map<Integer, String> loadCountries();
	
	public Map<Integer, String> loadStates(Integer CountryId);
	
	public Map<Integer, String> loadCities(Integer StateId);
	
	public String UserRegisteration(UserRegistrationForm user);
	
	public String UnlockAccount(UnlockForm unlock);
	
	public String Forgetpassword(String email);
	
}
