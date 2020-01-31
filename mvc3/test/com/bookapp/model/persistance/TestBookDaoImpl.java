package com.bookapp.model.persistance;

import java.util.Date;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@ContextConfiguration(locations = "classpath:model-config.xml")
@TransactionConfiguration(defaultRollback = true, 
transactionManager = "transactionManager")
@RunWith(SpringJUnit4ClassRunner.class)
public class TestBookDaoImpl {

	@Autowired
	private BookDao bookDao;
	

	@Test
	public void testAddNewBook(){
		int countBeforeBookAdded=bookDao.getAllBooks().size();
		Book book=new Book("REA545", "spring in action", "abc", 400.00,
				"rgupta.mtech@gmail.com", "raj", new Date());
		bookDao.addBook(book);
		int countAfterBookAdded=bookDao.getAllBooks().size();
		
		Assert.assertEquals(countAfterBookAdded, countBeforeBookAdded+1);
	}
	
	@Test
	public void testGetBookByIsbn(){
		Book book=bookDao.getBookByIsbn("808ABX");
		Assert.assertNotNull(book);
	}
	
	

	@Test
	public void testGetBookById(){
		Book book=bookDao.getBookById(1);
		Assert.assertNotNull(book);
	}
	
	@Test(expected=BookNotFoundException.class)
	public void testGetBookByIdNotFound(){
		Book book=bookDao.getBookById(100);
		Assert.assertNotNull(book);
	}
	
}

















