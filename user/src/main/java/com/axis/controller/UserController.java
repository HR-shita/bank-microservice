package com.axis.controller;

import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.axis.model.User;

@RequestMapping("/user")
public interface UserController {
	
	@PostMapping("/signup")
	public ResponseEntity<String> signUp(@RequestBody(required = true)User user);
	
	@PostMapping("/login")
	public ResponseEntity<String> logIn(@RequestBody(required = true)Map<String, String> map);

}
