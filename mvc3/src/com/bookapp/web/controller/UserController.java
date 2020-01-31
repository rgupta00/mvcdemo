package com.bookapp.web.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.bookapp.model.persistance.User;
import com.bookapp.model.persistance.UserNotFoundException;
import com.bookapp.model.service.UserService;

@Controller
public class UserController {

	private UserService userService;

	@Autowired
	public UserController(UserService userService) {
		this.userService = userService;
	}


	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/login?message=logout successfully!";
	}
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String landingpage(ModelMap map) {
		return "redirect:/login";
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String loginGet(ModelMap map) {
		map.addAttribute("user", new User());
		return "login";
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String loginPost(@ModelAttribute(value = "user") User user, 
			HttpSession session) {

		User user2 ;
		try {
		user2= userService.getUser(user.getUsername(),
					user.getPassword());
			System.out.println("--------------------");
			System.out.println(user2);
			session.setAttribute("user", user2);
			return "redirect:/allbooks";
		} catch (UserNotFoundException ex) {
			//session.setAttribute("error", "login failed");
			return "redirect:/login?error=login failed";
		}
	}

}




