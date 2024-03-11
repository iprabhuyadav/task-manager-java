package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.UserRegistration;

@Repository
public interface UserRepository extends JpaRepository<UserRegistration, Integer> {

}
