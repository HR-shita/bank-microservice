package com.axis.repositry;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.axis.model.User;

@Repository
public interface UserDao extends JpaRepository<User, Integer> {
	
	public User findUserByEmail(String email);
	
}
