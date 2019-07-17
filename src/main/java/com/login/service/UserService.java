package com.login.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import com.login.dao.UserMapper;
import com.login.entity.User;

@Service
public class UserService {

	@Autowired
	private UserMapper mapper;

	private final static String MD5_STRING = "LALALA123";

	public String checkUser(String id, String pwd) {
		User user = mapper.getUser(id);
		pwd = DigestUtils.md5DigestAsHex(pwd.getBytes());
		if (user.getPwd().equals(pwd)) {
			String md5Str = id.substring(0, 4) + MD5_STRING + id.substring(4);
			String md5DigestAsHex = DigestUtils.md5DigestAsHex(md5Str.getBytes());
			return md5DigestAsHex;
		}
		return "";
	}

	public boolean addUser(String id, String userName, String pwd, String tel) {
		try {
			pwd = DigestUtils.md5DigestAsHex(pwd.getBytes());
			mapper.addUser(id, userName, pwd, tel);
		} catch (Exception e) {
			return false;
		}
		return true;
	}

	public boolean checkToken(String token, String id) {
		String str = id.substring(0, 4) + MD5_STRING + id.substring(4);
		return str.equals(token);
	}

}
