package com.jk.login.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jk.login.dao.LoginDao;
import com.jk.login.entity.User;
import com.jk.login.service.LoginService;

@Service("loginService")
public class LoginServiceImpl implements LoginService {

	@Autowired
	private LoginDao userDao;
	
	@Override
	public boolean doLogin(User user) {
		
		boolean  bool = false;
		
		User getUser = new User();
		getUser = userDao.doLogin(user);
		
		if(getUser != null) {
			bool = true;
		}
		return bool;
	}

}
