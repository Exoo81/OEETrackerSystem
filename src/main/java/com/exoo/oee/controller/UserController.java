package com.exoo.oee.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.exoo.oee.service.UserService;

@Controller
public class UserController {

	
	@Autowired
	private UserService userService;
	
	@RequestMapping("/users")
	public String users(Model model){
		model.addAttribute("usersWOW", userService.findAll());
		return "users";
	}
	
	
	// example for fetch=FetchType.LAZY
	/*@RequestMapping("/reports/{id}")
	public String usersReports(Model model, @PathVariable int id){
		model.addAttribute("usersWOW", userService.findOne(id));
		return "user_report_list";
	}*/
}
