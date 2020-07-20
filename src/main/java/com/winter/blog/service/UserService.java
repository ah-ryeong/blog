package com.winter.blog.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.winter.blog.model.User;
import com.winter.blog.repository.UserRepository;

// Controller, Repository, Configuration, Service, Component
// RestController, Bean

@Service // IoC
public class UserService {

	@Autowired
	private UserRepository userRepository; // DI

	public int 회원가입(User user) {
		try {
			userRepository.save(user);
			return 1;
		} catch (Exception e) {
			e.getMessage();
			return -1;
		}
	}

	@Transactional(readOnly = true)
	public User 로그인(User user) {
		return userRepository.login(user);
	}

}
