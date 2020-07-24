package com.winter.blog.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.winter.blog.model.Post;
import com.winter.blog.repository.PostRepository;

// Controller, Repository, Configuration, Service, Component
// RestController, Bean

@Service // IoC
public class PostService {

	@Autowired
	private PostRepository postRepository; // DI

	@Transactional
	public void 글쓰기(Post post) {
		postRepository.save(post);
	}
}
