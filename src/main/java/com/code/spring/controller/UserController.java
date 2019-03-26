package com.code.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.code.spring.dao.UserDAO;
import com.code.spring.model.User;

@Controller
@RequestMapping(value="/user")
public class UserController {
	
	@Autowired
	private UserDAO userDao;
	
	@RequestMapping
	public ModelAndView userList(ModelAndView model) {
		System.out.println("User Page Requested");
		List<User> listUser = userDao.list();
		model.addObject("listUser",listUser);
		model.setViewName("user");
		return model;
	}
	

	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public ModelAndView user(ModelAndView model) {
		User user = new User();
		model.addObject(user);
		model.setViewName("userForm");
		return model;
	}
	
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public ModelAndView createUser(@ModelAttribute  User user, RedirectAttributes redir) {
		ModelAndView modelAndView = new ModelAndView("redirect:/user");
		try {
			userDao.create(user);
			System.out.println("User Created");
			redir.addFlashAttribute("message","Create User Success!");
		}catch (Exception e) {
			System.out.println("Created User Error : \n"+e);
			redir.addFlashAttribute("message","Create User Error!");
		}
		
		return modelAndView;
	}
	
	@RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
	public ModelAndView editUser(@PathVariable("id")int id, ModelAndView model) {
		ModelAndView modelAndView = new ModelAndView("editUser");
		User user = userDao.get(id);
		modelAndView.addObject("user",user);
		
		return modelAndView;
	}
	
}
