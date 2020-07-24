package com.winter.blog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.winter.blog.controller.dto.CommonRespDto;
import com.winter.blog.model.Post;
import com.winter.blog.service.PostService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class PostController {
	
	private final PostService postService;
	
//	public PostController(PostService postService) {
//		this.postService = postService;
//	}

	@GetMapping("/post/saveForm")
	public String postForm() {
		return "post/saveForm";
	}
	
	@PostMapping("/post")
	public @ResponseBody CommonRespDto<?> postProc(@RequestBody Post post) {
		postService.글쓰기(post);
		
		return new CommonRespDto<String>(1, "글쓰기 성공");
	}
}
