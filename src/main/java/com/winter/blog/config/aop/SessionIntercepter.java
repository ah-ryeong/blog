package com.winter.blog.config.aop;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.winter.blog.model.User;

// 인증 관리
public class SessionIntercepter extends HandlerInterceptorAdapter {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		System.out.println("인증을 체크해야함");
		HttpSession session = request.getSession();
		User principal = (User)session.getAttribute("principal");
		if (principal == null) {
			response.setContentType("text/html; charset=utf-8");
			
			PrintWriter out = response.getWriter();
			out.print("<script>");
			out.print("alert('로그인이 필요합니다.');");
			out.print("location.href='/auth/loginForm';");
			out.print("</script>");
			return false; // 더 이상 진입 안 됨
		}

		return true;
	}
}
