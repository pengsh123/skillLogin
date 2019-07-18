package com.login.action;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.login.service.UserService;

@Controller
public class ActionLogin {

	@Autowired
	private UserService userService;

	/**
	 * 登录验证
	 */
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	@ResponseBody
	public String login(String id, String pwd) {
		String token = "";
		token = userService.checkUser(id, pwd);
		return token;
	}
	
	/**
	 * 登录验证
	 */
	@RequestMapping(value = "/checkId", method = RequestMethod.POST)
	@ResponseBody
	public boolean checkId(String id) {
		return userService.checkId(id);
	}
	

	/**
	 * 登录界面
	 */
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login() {
		return "login";
	}

	/**
	 * 注册
	 */
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	@ResponseBody
	public boolean register(String id, String userName, String pwd, String tel) {
		boolean addUser = userService.addUser(id, userName, pwd, tel);
		return addUser;
	}
	
	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public String register() {
		return "register";
	}

}
