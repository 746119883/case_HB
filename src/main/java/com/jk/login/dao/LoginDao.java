
package com.jk.login.dao;

import com.jk.login.entity.User;

public interface LoginDao {
	
	/**
	 * @功能 用户登录
	 * @return
	 */
	public User doLogin(User user);
	
	
}
