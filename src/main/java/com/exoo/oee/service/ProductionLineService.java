package com.exoo.oee.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.exoo.oee.entity.ProductionLine;
import com.exoo.oee.entity.Role;
import com.exoo.oee.entity.User;
import com.exoo.oee.entity.UserDetails;
import com.exoo.oee.repository.ProductionLineRepository;
import com.exoo.oee.repository.UserDetailsRepository;
import com.exoo.oee.repository.UserRepository;

@Service
@Transactional
public class ProductionLineService {
	
	
	@Autowired
	private ProductionLineRepository productionLineRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private UserDetailsRepository userDetailsRepository;

	public Page<ProductionLine> findAll(Integer pageNumber) {
		PageRequest request =
	            new PageRequest(pageNumber - 1, 10, Sort.Direction.DESC, "id");
		Page<ProductionLine> page = productionLineRepository.findAll(request);
		
		List<ProductionLine> prodLineList = page.getContent();
		
		for(ProductionLine pL : prodLineList){
			/*User productionLineCreatedBy = userRepository.findByCreatedProductionLines(pL);
			pL.setProductionLineCreatedBy(productionLineCreatedBy);*/
			List<User> authorizedUsers = userRepository.findByAuthorizedProductionLines(pL);
			pL.setAuthorizedUsers(authorizedUsers);
		}
		
		return page;
	}

	public void save(ProductionLine pl, String name) {
		User user = userRepository.findByUsername(name);
		pl.setProductionLineCreatedBy(user);
		productionLineRepository.save(pl);
		
	}

	public void delete(int id) {
		productionLineRepository.delete(id);
		
	}
	
	public ProductionLine findProductionLine(int productionLineID) {
		
		return productionLineRepository.findOne(productionLineID);
	}

	public Page<User> findAllAuthorizedUsers(int productionLineID, Integer pageNumber) {
		
		PageRequest request = new PageRequest(pageNumber - 1, 10, Sort.Direction.DESC, "id");
		
		ProductionLine pL = productionLineRepository.findOne(productionLineID);
		Page<User> pages = userRepository.findByAuthorizedProductionLines(pL, request);
		
		List<User> users = pages.getContent();
		
		for(User user : users){
			
			UserDetails userDetails = userDetailsRepository.findByUser(user);
			user.setUserDetails(userDetails);
			//System.out.println("User: " + user.toString());
		}
		
		return pages;
	}

	public void deleteAuthorizedProductionLine(int idUser, int productionLineID) {
		ProductionLine pl = productionLineRepository.findOne(productionLineID);
		User user = userRepository.findOne(idUser);
		
		List<ProductionLine> authProductionLines = user.getAuthorizedProductionLines();
		
		authProductionLines.remove(pl);
		
		user.setAuthorizedProductionLines(authProductionLines);
		
		userRepository.save(user);
		
	}


}
