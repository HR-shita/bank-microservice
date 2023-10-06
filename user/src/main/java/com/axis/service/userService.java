package com.axis.service;

import java.util.Map;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.axis.jwt.JwtUtils;
import com.axis.model.User;
import com.axis.repositry.UserDao;

@Service
public class userService {

	@Autowired
	private UserDao userDao;

	@Autowired
	private JwtUtils jwtUtils;

	public boolean signUp(User user) {
		try {

			User userCheck = userDao.getUserByUsername(user.getUsername());
			
			if (Objects.isNull(user))
				return false;
			else if (user.getEmail().isEmpty() || user.getName().isEmpty() || user.getPhoneNumber().isEmpty()
					|| user.getUsername().isEmpty()) {
				return false;
			} else {
				
				if (Objects.isNull(userCheck)) {
					user.setRole("user");
					user.setStatus("true");

					userDao.save(user);
					return true;
				} else return false;
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	public ResponseEntity<String> logIn(Map<String, String> map) {
		try {

			String username = map.get("username");

			String password = map.get("password");

			User user = userDao.getUserByUsername(username);

			if (Objects.isNull(user)) {
				return new ResponseEntity<String>("No user found by this username", HttpStatus.BAD_REQUEST);
			} else if (user.getPassword().equals(password)) {

				String token = jwtUtils.generateToken(username, user.getRole());
				return new ResponseEntity<String>(token, HttpStatus.OK);

			} else {
				return new ResponseEntity<String>("Wrong password", HttpStatus.BAD_REQUEST);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
