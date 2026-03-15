package com.minnanoDoctor.reservation.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "users") // 테이블명 지정
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(unique = true) // 同じメールは使用不可。
	private String email;

	private String password;

	private String name;

}
