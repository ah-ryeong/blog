package com.winter.blog.repository;

import java.util.List;

import com.winter.blog.model.Account;

public interface AccountRepository {

	// 인터페이스니까 추상클래스임
	public void update(Account account);
	public List<Account> findAll();
	public Account findByAccountNumber(String accountNumber);
}
