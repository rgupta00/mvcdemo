package com.bookapp.model.service;

import com.bookapp.model.persistance.User;

public interface UserService {
	public User getUser(String username, String password);
	public void addUser(User user);
}
