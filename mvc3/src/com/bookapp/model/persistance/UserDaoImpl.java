package com.bookapp.model.persistance;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UserDaoImpl implements UserDao {
	private SessionFactory sessionFactory;
	
	@Autowired
	public UserDaoImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	private Session getSession(){
		return sessionFactory.getCurrentSession();
	}
	@Override
	public User getUser(String username, String password) {
		User user = (User) getSession().createQuery
		("select u from User u where u.username=:username and u.password=:password")
		.setString("username", username)
		.setString("password", password)
		.uniqueResult();
		if(user==null)
			throw new UserNotFoundException("invalid user");
		return user;
	}

	@Override
	public void addUser(User user) {
		getSession().save(user);
	}

}









