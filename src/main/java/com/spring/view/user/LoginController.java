package com.spring.view.user;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.spring.sample.user.UserVO;
import com.spring.sample.user.impl.UserDAO;

@Controller
public class LoginController {
	
	@RequestMapping(value="/login.do",method = RequestMethod.GET)
	public String loginView(UserVO vo) {
		
		vo.setId("test");
		vo.setPassword("test123");
		return "login.jsp";
	}
	
	@RequestMapping(value="/login.do",method = RequestMethod.POST)
	public String login(UserVO vo, UserDAO userDAO, HttpSession session) {
		System.out.println("로그인 처리");
		
		UserVO user  = userDAO.getUser(vo);
		if(user != null){
			session.setAttribute("userName", user.getName());
			return "getBoardList.do";
		}
		else return "login.jsp";
	}

}
