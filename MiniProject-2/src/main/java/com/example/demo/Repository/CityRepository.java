package com.example.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.Entity.CityMasterEntity;

public interface CityRepository extends JpaRepository<CityMasterEntity, Integer> {

}
