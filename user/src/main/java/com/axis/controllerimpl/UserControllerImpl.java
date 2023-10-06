package com.axis.controllerimpl;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.axis.controller.UserController;
import com.axis.model.User;
import com.axis.service.userService;

@RestController
public class UserControllerImpl implements UserController {

	@Autowired
	private userService userService;

	@Override
	public ResponseEntity<String> signUp(User user) {
		try {

			boolean ans = userService.signUp(user);

			if (ans)
				return ResponseEntity.status(HttpStatus.CREATED).body("CREATED");
			else
				return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("SOME FILELDS ARE MISSING");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("INTERNAL SERVER ERROR");
	}

	@Override
	public ResponseEntity<String> logIn(Map<String, String> map) {
		try {
			
			return userService.logIn(map);
			
		} catch (Exception e) {
			e.printStackTrace();
		}

		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("INTERNAL SERVER ERROR");
	}

}
