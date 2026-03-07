package com.minnanoDoctor.reservation.service;

import org.springframework.stereotype.Service;

import com.minnanoDoctor.reservation.entity.User;
import com.minnanoDoctor.reservation.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserService {
	private final UserRepository userRepository;

	public User register(User user) {
		return userRepository.save(user);
	}
}
