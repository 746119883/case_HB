package com.jk.login.controller;


import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jk.login.entity.User;
import com.jk.login.service.LoginService;


@Controller
@RequestMapping("/login")
public class LoginController {

    @Resource
    private LoginService loginService;

    //登录页面
    private static final String LOGIN_URL="login/Login";
    
    //主页面
    private static final String MAIN_URL = "main/Main";
    
    //首页
    private static final String MAIN_INDEX_URL = "main/Index";
    
    /**
     * @功能 登录页面
     * @return
     */
    @RequestMapping("/goLogin")
    public String goLogin() {
        
        return LOGIN_URL;
    }
    
    /**
     * @功能 首页面
     * @return
     */
    @RequestMapping("/goIndex")
    public String goMain() {
        
        return MAIN_INDEX_URL;
    }
    
    /**
     * @功能 用户登录
     * @param user
     * @return message
     */
    
    @RequestMapping("/doLogin")
    public String doLogin(HttpServletRequest request,Model model,User user) {

    	String message = "";
    	boolean bool = false;
    	String username = user.getUsername();
    	String password = user.getPassword();
    	
    	if(username == null || "".equals(username)) {
    		message = "用户名不能为空";
    	}else if(password == null || "".equals(password)) {
    		message = "密码不能为空";
    	}
    	
    	if(!"".equals(message)) {
    		model.addAttribute(message);
    		return LOGIN_URL;
    	}
    	
    	bool = loginService.doLogin(user);
    	
    	if(bool) {
        	
        	return MAIN_URL;
    	}else {
    		message = "用户名或密码错误";
    		model.addAttribute("message",message);
        	return LOGIN_URL;
    	}
    }
}
