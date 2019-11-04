package com.spring.sample.user.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.spring.sample.user.UserService;
import com.spring.sample.user.UserVO;

@Service("UserService")
public class UserServiceImpl implements UserService{
	@Autowired
	private UserDAO_Mybatis userDAO;
	
//	public void setUserDAO(UserDAO userDAO) {
//		this.userDAO = userDAO;
//	}
	
	@Transactional(readOnly=true)
	@Override
	public UserVO getUser(UserVO vo) {
		return userDAO.getUser(vo);
	}
}
