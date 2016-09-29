package com.exoo.oee.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.exoo.oee.entity.ProductionLine;
import com.exoo.oee.entity.User;
import com.exoo.oee.repository.ProductionLineRepository;
import com.exoo.oee.repository.UserRepository;

@Service
@Transactional
public class ProductionLineService {
	
	
	@Autowired
	private ProductionLineRepository productionLineRepository;
	
	@Autowired
	private UserRepository userRepository;

	public Page<ProductionLine> findAll(Integer pageNumber) {
		PageRequest request =
	            new PageRequest(pageNumber - 1, 10, Sort.Direction.DESC, "id");
		Page<ProductionLine> page = productionLineRepository.findAll(request);
		
		
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

}
