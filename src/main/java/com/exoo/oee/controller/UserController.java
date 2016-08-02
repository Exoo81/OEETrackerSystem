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
	
	@RequestMapping("/users/{id}")
	public String getUserDetailsByUserId(Model model, @PathVariable int id){
		model.addAttribute("userDetailsWoW", userService.getOne(id));
		return "user_details";
	}
	
	@RequestMapping("/reports/{id}")
	public String getUserReport(Model model, @PathVariable int id){
		model.addAttribute("reportsWoW", userService.getOneWithReports(id));
		return "user_report_list";
	}
	// example for fetch=FetchType.LAZY
	/*@RequestMapping("/reports/{id}")
	public String usersReports(Model model, @PathVariable int id){
		model.addAttribute("usersWOW", userService.findOne(id));
		return "user_report_list";
	}*/
}
