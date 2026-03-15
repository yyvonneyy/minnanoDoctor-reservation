package com.minnanoDoctor.reservation.security;

import java.util.Date;

import org.springframework.stereotype.Component;

import java.security.Key;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;

@Component
public class JwtUtil {
	// JWTは偽造防止のため、署名（signature）を生成。 
	// その時、署名生成に使用する秘密のキーを宣言。
	private final String secretKey = "mysecretkeymysecretkeymysecretkey";

	private final Key key = Keys.hmacShaKeyFor(secretKey.getBytes()); // 秘密のキー 生成


	public String generateToken(String email) {
		return Jwts.builder() // JWT TOKEN 生成開始
				.setSubject(email).setIssuedAt(new Date()) // TOKEN 発給時間
				.setExpiration(new Date(System.currentTimeMillis() + 86400000)) // TOKEN 満了時間
				.signWith(key) // JWT　署名生成
				.compact();
	}

}
