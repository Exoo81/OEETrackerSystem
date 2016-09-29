package com.exoo.oee.controller;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.exoo.oee.entity.Role;
import com.exoo.oee.entity.User;
import com.exoo.oee.service.RoleService;
import com.exoo.oee.service.UserService;
import com.exoo.oee.wrapper.UserRegistrationWrapper;

@Controller
public class UserController {

	
	@Autowired
	private UserService userService;
	
	@Autowired
	private RoleService roleService;
	
	/*@ModelAttribute("user")
	public User userInitializer(){
		User user = new User();
		user.setRoles(new ArrayList<Role>());
		return user;
	}*/
	
	@ModelAttribute("rolesList")
	public List<Role> rolesListInitializer(){
		List<Role> roles = new ArrayList<Role>();
		roles = roleService.findAll();
		
		return roles;
	}
	
	@ModelAttribute("userRegistrationForm")
	public UserRegistrationWrapper userRegistrationForm(){
		return new UserRegistrationWrapper();
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
	public String doRegister(@ModelAttribute ("userRegistrationForm")UserRegistrationWrapper newUser, BindingResult result){
		
		/*System.out.println("start");
		
		System.out.println("username: " + newUser.getUsername());
		System.out.println("password: " + newUser.getPassword());
		System.out.println("first name: " + newUser.getFirstName());
		System.out.println("last name: " + newUser.getLastName());
		System.out.println("job title: " + newUser.getJobTitle());
		System.out.println("email: " + newUser.getEmail());
		
		System.out.println("ROLES:");
		if(!(newUser.getRoleId().isEmpty())){
			System.out.println("NOT empty");
			for(Integer roleId : newUser.getRoleId()){
				System.out.println(roleId);
			}
		}else{
			System.out.println("empty");
		}*/
		
		userService.save(newUser);
		return "redirect:register.html?success=true";
	}
	
	// example for fetch=FetchType.LAZY
	/*@RequestMapping("/reports/{id}")
	public String usersReports(Model model, @PathVariable int id){
		model.addAttribute("usersWOW", userService.findOne(id));
		return "user_report_list";
	}*/
	
	@RequestMapping("/account")
	public String account(Model model, Principal principal){
		String name = principal.getName();
		String account = "account";
		//System.out.println(name);
		model.addAttribute("userDetailsWoW", userService.getOne(name));
		model.addAttribute("account", account);
		return "user_details";
	}
}
