package com.exoo.oee.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.exoo.oee.service.UserDetailsService;


@Controller
public class UserDetailsController {

	/*@Autowired
	private UserDetailsService userDetailsService;
	
	@RequestMapping("/users/{id}")
	public String getUserDetails(Model model, @PathVariable int id){
		model.addAttribute("userDetailsWoW", userDetailsService.getUserDetails(id));
		return "user_details";
	}*/
	
}
