package com.habuma.spitter.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.habuma.spitter.dao.IUserDao;
import com.habuma.spitter.entity.User;
import com.habuma.spitter.service.IUserService;

@Service("userService")
public class UserServiceImpl implements IUserService {

	@Autowired
	private IUserDao userDao;
	
	@Override
	public User getUserById(int userId) {
		
		return userDao.selectByPrimaryKey(userId); 
	}

	@Override
	public void addUser(User user) {
		userDao.insert(user);
	}

}
