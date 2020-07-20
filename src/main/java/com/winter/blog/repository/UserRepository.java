package com.winter.blog.repository;

import com.winter.blog.model.User;

public interface UserRepository {

	public void save(User user);
	public User login(User user);
}
