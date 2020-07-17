package com.winter.blog.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.winter.blog.dto.SendRequestDto;
import com.winter.blog.dto.WithDrawRequestDto;
import com.winter.blog.model.Account;
import com.winter.blog.service.AccountService;

@Controller
public class AccountController {
	
	@Autowired
	private AccountService accountService;
	
	@GetMapping("/account")
	public @ResponseBody List<Account> findAll() {
		return accountService.계좌정보보기();
	}
	
	@PutMapping("/send")
	public @ResponseBody String send(SendRequestDto dto) {
		// 데이터만 리턴해줄거임
		
		accountService.송금(dto);
		return "<h1>송금이 완료되었습니다</h1>";
	}
	
	@PutMapping("/withdraw")
	public @ResponseBody String withdraw(WithDrawRequestDto dto) {
		// 데이터만 리턴해줄거임
		accountService.인출(dto);
		return "<h1>인출이 완료되었습니다</h1>";
	}
}
