package com.bookapp.model.persistance;

public interface UserDao {
	public User getUser(String username, String password);
	public void addUser(User user);
	
}
