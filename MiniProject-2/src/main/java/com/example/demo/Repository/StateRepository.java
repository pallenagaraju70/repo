package com.example.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.Entity.StateMasterEntity;

public interface StateRepository extends JpaRepository<StateMasterEntity, Integer> {

}
