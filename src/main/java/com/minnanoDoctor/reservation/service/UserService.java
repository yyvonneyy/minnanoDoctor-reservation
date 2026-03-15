package com.minnanoDoctor.reservation.service;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.minnanoDoctor.reservation.dto.LoginRequest;
import com.minnanoDoctor.reservation.dto.LoginResponse;
import com.minnanoDoctor.reservation.entity.User;
import com.minnanoDoctor.reservation.repository.UserRepository;
import com.minnanoDoctor.reservation.security.JwtUtil;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserService {
	private final UserRepository userRepository;
	private final PasswordEncoder passwordEncoder; // SecurityConfigで Bean生成後、constructor生成。
	private final JwtUtil jwtUtil;
	
	public User register(User user) { // User登録 Method
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		
		return userRepository.save(user);
	}

	// Login Method
	// 戻り値 型：LoginResponse（User代わりにJWTのTOKENを返却）
	public LoginResponse login(LoginRequest request) { 

		User user = userRepository.findByEmail(request.getEmail())
				.orElseThrow(() -> new RuntimeException("User not found"));

		if (!passwordEncoder.matches(request.getPassword(), user.getPassword())) {
			throw new RuntimeException("Invalid password");
		}
		String token = jwtUtil.generateToken(user.getEmail());
		
		//TokenをLoginResponse DTOに格納して返却する
		return new LoginResponse(token);
	}
}
