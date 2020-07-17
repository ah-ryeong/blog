package com.winter.blog.service;

import java.util.List;

import org.eclipse.jdt.internal.compiler.ast.TrueLiteral;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.winter.blog.dto.SendRequestDto;
import com.winter.blog.dto.WithDrawRequestDto;
import com.winter.blog.model.Account;
import com.winter.blog.repository.AccountRepository;

@Service
public class AccountService {

	@Autowired
	private AccountRepository accountRepository;
	
	@Transactional
	public void 송금(SendRequestDto dto) {
		// 보내는 사람 업데이트(-)
		// 트랜젝션 시작 -> 함수 끝 날때 끝난다. (하나라도 실패하면 롤백, 둘 다 성공하면 커밋)
		Account 홍길동 = accountRepository.findByAccountNumber(dto.getReceiverAccountNumber());
		홍길동.setMoney(홍길동.getMoney()-dto.getMoney());
		accountRepository.update(홍길동);
		
		// 받는사람 업데이트(+)
		Account 장보고 = accountRepository.findByAccountNumber(dto.getReceiverAccountNumber());
		장보고.setMoney(장보고.getMoney()+dto.getMoney());
		accountRepository.update(장보고);
	}

	@Transactional
	public void 인출(WithDrawRequestDto dto) {
		Account 홍길동 = accountRepository.findByAccountNumber(dto.getAccountNumber());
		홍길동.setMoney(홍길동.getMoney()-dto.getMoney());
		accountRepository.update(홍길동);
	}
	
	@Transactional(readOnly = true) // 고립성
	public List<Account> 계좌정보보기() {
		
		return accountRepository.findAll();
	}
}
