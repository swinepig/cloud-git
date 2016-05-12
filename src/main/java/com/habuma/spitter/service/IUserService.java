package com.habuma.spitter.service;

import com.habuma.spitter.entity.User;

public interface IUserService {
	
	public User getUserById(int userId);  
	
	public void addUser(User user);

}
