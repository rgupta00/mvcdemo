package com.bookapp.model.service;
import java.util.*;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.bookapp.model.persistance.Book;
import com.bookapp.model.persistance.User;

public class Main {

	public static void main(String[] args) {
		ApplicationContext
		ctx=new ClassPathXmlApplicationContext("model-config.xml");
		
		UserService service=(UserService) ctx.getBean("us");
		//service.addUser(new User("rgupta", "raj", "mgr"));
		//service.addUser(new User("ekta", "ekta", "clerk"));
		
		User user=service.getUser("rgupta", "raj");
		System.out.println(user);
		
		/*BookService bookService=(BookService) ctx.getBean("bs");
		
		bookService.addBook
		(new Book("ASWZ", "spring in action", "abc", 400.00,
				"rgupta.mtech@gmail.com", "raj", new Date()));*/
		
		//bookService.updateBook(10, 470);
		
	}
}
