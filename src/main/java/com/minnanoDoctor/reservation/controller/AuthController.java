package com.minnanoDoctor.reservation.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.minnanoDoctor.reservation.dto.LoginRequest;
import com.minnanoDoctor.reservation.entity.User;
import com.minnanoDoctor.reservation.service.UserService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

	private final UserService userService;

	@PostMapping("/register")
	public User register(@RequestBody User user) {
		return userService.register(user);
	}
	
	@PostMapping("/login")
	public User login(@RequestBody LoginRequest request) {
	    return userService.login(request);
	}

}
