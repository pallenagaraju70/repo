package com.example.demo.bindings;

import lombok.Data;

@Data
public class UnlockForm {

	
	private String email;
	
	private String Temppwd;
	
	private String Newpassword;
	
	private String Confirmpassword;

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTemppwd() {
		return Temppwd;
	}

	public void setTemppwd(String temppwd) {
		Temppwd = temppwd;
	}

	public String getNewpassword() {
		return Newpassword;
	}

	public void setNewpassword(String newpassword) {
		Newpassword = newpassword;
	}

	public String getConfirmpassword() {
		return Confirmpassword;
	}

	public void setConfirmpassword(String confirmpassword) {
		Confirmpassword = confirmpassword;
	}
	
	
	
}
