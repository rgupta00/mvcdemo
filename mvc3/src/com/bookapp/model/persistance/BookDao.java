package com.bookapp.model.persistance;

import java.util.List;

public interface BookDao {
	public List<Book> getAllBooks();
	public void deleteBook(int bookId);
	public void updateBook(int bookId,double prices);
	public void addBook(Book book);
	public Book getBookById(int bookId);
	public Book getBookByIsbn(String isbn);
}
