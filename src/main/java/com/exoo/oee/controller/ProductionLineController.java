package com.exoo.oee.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.exoo.oee.entity.ProductionLine;
import com.exoo.oee.entity.User;
import com.exoo.oee.entity.UserDetails;
import com.exoo.oee.service.ProductionLineService;

@Controller
public class ProductionLineController {

	@Autowired
	private ProductionLineService productionLineService;
	
	
	@ModelAttribute("productionLine")
	public ProductionLine construct(){
		return new ProductionLine();
	}
	
	@RequestMapping("/{pageNumber}/production_lines")
	public String productionLinesList(Model model, @PathVariable Integer pageNumber){
		Page<ProductionLine> productionLineList = productionLineService.findAll(pageNumber);
		
		int current = productionLineList.getNumber() + 1;
	    int begin = Math.max(1, current - 5);
	    int end = Math.min(begin + 10, productionLineList.getTotalPages());
		
	    List<ProductionLine> productionLinesList = productionLineList.getContent();
	    
	    model.addAttribute("deploymentProductionLines", productionLineList);
	    model.addAttribute("beginIndex", begin);
	    model.addAttribute("endIndex", end);
	    model.addAttribute("currentIndex", current);
	    model.addAttribute("productionLinesWoW", productionLinesList);
	    
		return "production_lines";

	}
	
	@RequestMapping(value="/{pageNumber}/production_lines", method=RequestMethod.POST)
	public String createProductionLine(@ModelAttribute("productionLine") ProductionLine pl, Principal principal){
		
		String name = principal.getName();
		productionLineService.save(pl, name);
		
		return "redirect:/1/production_lines.html?success=true";
	}
	
	@RequestMapping("/production_lines/remove/{id}")
	public String removeProductionLine(@PathVariable int id){
		productionLineService.delete(id);
		return "redirect:/1/production_lines.html";
		
	}
	
	@RequestMapping("/production_lines/users/{productionLineID}")
	public String findAllAuthorizedUsersByProductionLineID(Model model, @PathVariable int productionLineID){
		
		ProductionLine pL = productionLineService.findProductionLine(productionLineID);
		List<User> authorizedUsers = productionLineService.findAllAuthorizedUsers(productionLineID);
		String parentLink = "productionLine";
		
		model.addAttribute("productionLine", pL);
		model.addAttribute("authUsersWoW", authorizedUsers);
		model.addAttribute("parentLink", parentLink);
		
		return "authorized_users";
		
	}
	
	@RequestMapping("/production_lines/remove/user/{idUser}/{productionLineID}")
	public String removeAuthorizedUser(@PathVariable int idUser, @PathVariable int productionLineID){
		productionLineService.deleteAuthorizedProductionLine(idUser, productionLineID);
		return "redirect:/production_lines/users/{productionLineID}.html?removeFromList=true";
		
	}
	
}
