package com.winter.blog.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CommonRespDto<T> {

	private int statusCode; // 응답코드 1정상, -1 실패, 0 변경안됨
	private T data;
}
