package com.bookapp.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bookapp.model.persistance.User;
import com.bookapp.model.persistance.UserDao;
@Service(value="us")
@Transactional
public class UserServiceImpl implements UserService {

	private UserDao userDao;
	
	@Autowired
	public UserServiceImpl(UserDao userDao) {
		this.userDao = userDao;
	}

	@Override
	public User getUser(String username, String password) {
		return userDao.getUser(username, password);
	}

	@Override
	public void addUser(User user) {
		userDao.addUser(user);
	}

}




