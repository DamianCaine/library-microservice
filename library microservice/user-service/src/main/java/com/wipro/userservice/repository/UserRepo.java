package com.wipro.userservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wipro.userservice.entity.Users;

@Repository
public interface UserRepo extends JpaRepository<Users, Integer> {

	Users findUserByUserId(String userId);
}
