package com.exoo.oee.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.exoo.oee.entity.DailyReport;
import com.exoo.oee.entity.User;
import com.exoo.oee.service.UserService;

@Controller
public class UserController {

	
	@Autowired
	private UserService userService;
	
	@ModelAttribute("user")
	public User construct(){
		return new User();
	}
	
	
	@RequestMapping("/{pageNumber}/users")
	public String users(Model model, @PathVariable Integer pageNumber){
		Page<User> page = userService.findAll(pageNumber);
		
		int current = page.getNumber() + 1;
	    int begin = Math.max(1, current - 5);
	    int end = Math.min(begin + 10, page.getTotalPages());
	    
	    List<User> users = page.getContent();
	    
	    model.addAttribute("deploymentUsers", page);
	    model.addAttribute("beginIndex", begin);
	    model.addAttribute("endIndex", end);
	    model.addAttribute("currentIndex", current);
	    model.addAttribute("usersWoW", users); // add by me
		
	    
		return "users";
	}
	
	@RequestMapping("/users/{id}")
	public String getUserDetailsByUserId(Model model, @PathVariable int id){
		model.addAttribute("userDetailsWoW", userService.getOne(id));
		return "user_details";
	}
	
	/*@RequestMapping("/user/{id}/reports")
	public String getUserReport(Model model, @PathVariable int id){
		model.addAttribute("userWoW", userService.getOneWithReports(id));
		return "user_report_list";
	}*/
	
	@RequestMapping("/register")
	public String showRegister(){
		return "user_register";
	}
	
	@RequestMapping(value="/register", method=RequestMethod.POST)
	public String doRegister(@ModelAttribute("user") User user){
		userService.save(user);
		return "user_register";
	}
	
	// example for fetch=FetchType.LAZY
	/*@RequestMapping("/reports/{id}")
	public String usersReports(Model model, @PathVariable int id){
		model.addAttribute("usersWOW", userService.findOne(id));
		return "user_report_list";
	}*/
}
