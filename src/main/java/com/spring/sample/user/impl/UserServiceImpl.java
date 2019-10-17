package com.spring.sample.user.impl;

import com.spring.sample.user.UserService;
import com.spring.sample.user.UserVO;

public class UserServiceImpl implements UserService{
	private UserDAO userDAO;
	
	public void setUserDAO(UserDAO userDAO) {
		this.userDAO = userDAO;
	}
	
	public UserVO getUser(UserVO vo) {
		return userDAO.getUser(vo);
	}
}
