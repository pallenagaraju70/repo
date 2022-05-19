package com.example.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.Entity.CountryMasterEntity;

public interface CountryRepository extends JpaRepository<CountryMasterEntity, Integer> {

}
