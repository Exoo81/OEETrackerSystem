package com.exoo.oee.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exoo.oee.entity.Role;
import com.exoo.oee.repository.RoleRepository;

@Service
@Transactional
public class RoleService {
	
	@Autowired
	private RoleRepository roleRepository;

	public List<Role> findAll() {
		
		return roleRepository.findAll();
	}

	public Role getById(Integer roleId) {
		// TODO Auto-generated method stub
		return roleRepository.getOne(roleId);
	}

}
