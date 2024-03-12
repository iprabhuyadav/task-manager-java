package com.example.demo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.UserRegistration;

@Repository
public interface UserRepository extends JpaRepository<UserRegistration, Integer> {

	@Query("select new map(emailAddress as emailAddress) from UserRegistration where emailAddress=?1")
	Optional<UserRegistration> findByEmail(String emailAddress);

	@Query("select new map(emailAddress as emailAddress, password as password, userId as userId, userName as userName) from UserRegistration where emailAddress=?1 and password=?2")
	Optional<UserRegistration> findByEmailAndPassword(String emailAddress, String password);

}
