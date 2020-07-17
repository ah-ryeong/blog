package com.winter.blog.dto;

import lombok.Builder;

import lombok.NoArgsConstructor;

import lombok.AllArgsConstructor;

import lombok.Data;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SendRequestDto {
	private String senderAccountNumber;
	private String receiverAccountNumber;
	private int money;
}
