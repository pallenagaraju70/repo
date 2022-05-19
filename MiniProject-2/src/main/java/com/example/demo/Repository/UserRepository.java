package com.example.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.Entity.UserDataEntity;
import com.example.demo.bindings.UserRegistrationForm;

public interface UserRepository extends JpaRepository<UserDataEntity, Integer> {
	
	public UserDataEntity findByEmailAndPassword(String email, String password);
	
	public UserDataEntity findByEmail(String email);

	public UserDataEntity findByEmail(UserRegistrationForm user);

}
