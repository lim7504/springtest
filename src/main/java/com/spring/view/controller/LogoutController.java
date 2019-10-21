package com.spring.view.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.spring.sample.user.UserVO;
import com.spring.sample.user.impl.UserDAO;

public class LogoutController implements Controller{
	
	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("로그아웃 처리");
		
       	HttpSession session = request.getSession();
       	session.invalidate();
       	
       	return "login";
	}
}
