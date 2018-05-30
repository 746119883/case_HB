package com.jk.login.service;

import com.jk.login.entity.User;

public interface LoginService {
	
	/**
	 * @功能 用户登录
	 * @param password
	 * @return
	 */
	public boolean doLogin(User user);
	
}
