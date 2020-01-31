package com.bookapp.web.controller;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.bookapp.model.persistance.Book;
import com.bookapp.model.service.BookService;

@Controller
public class BookController {

	private BookService bookService;

	@Autowired
	public BookController(BookService bookService) {
		this.bookService = bookService;
	}

	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public String home() {
		return "redirect:/allbooks";
	}

	@RequestMapping(value = "addbook", method = RequestMethod.GET)
	public String addBookGet(ModelMap map) {
		map.addAttribute("book", new Book());
		return "addbook";
	}

	@RequestMapping(value = "updatebook", method = RequestMethod.GET)
	public String updateBookGet(HttpServletRequest request, ModelMap map) {
		Integer id = Integer.parseInt(request.getParameter("id").trim());

		map.addAttribute("book", bookService.getBookById(id));
		return "addbook";
	}

	@RequestMapping(value = "addbook", method = RequestMethod.POST)
	public String addBookPost(@Valid @ModelAttribute(value = "book") Book book,
			BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			return "addbook";
		} else {
			if (book.getId() == null)// its a new book
				bookService.addBook(book);
			else
				bookService.updateBook(book.getId(), book.getPrice());
			return "redirect:/allbooks";
		}
	}

	@RequestMapping(value = "deletebook", method = RequestMethod.GET)
	public String deleteBook(HttpServletRequest request) {
		Integer id = Integer.parseInt(request.getParameter("id").trim());
		bookService.deleteBook(id);
		return "redirect:/allbooks";
	}

	@RequestMapping(value = "allbooks", method = RequestMethod.GET)
	public String hello(ModelMap map) {
		map.addAttribute("books", bookService.getAllBooks());
		return "allbooks";
	}
}
