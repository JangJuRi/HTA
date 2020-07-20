package com.simple.service;

import com.simple.dao.UserDao;
import com.simple.vo.User;

public class UserService {

	private UserDao userDao = new UserDao();
	
	public boolean addNewUser(User user) throws Exception {
		User savedUser = userDao.getUserById(user.getId());
		
		if(savedUser != null) {
			return false;
		}
		userDao.insertUser(user);
		return true;
	}
	
	public User loginCheck(String id, String password) throws Exception {
		User user = userDao.getUserById(id);
		
		if(user == null) {
			return null;
		}
		if(!password.equals(user.getPassword())) {
			return null;
		}
		
		return user;
	}
}
