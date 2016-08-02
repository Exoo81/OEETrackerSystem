package com.exoo.oee.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exoo.oee.repository.UserRepository;
import com.exoo.oee.entity.User;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;
	
	public List<User> findAll(){
		return userRepository.findAll();
	}

	// example for fetch=FetchType.LAZY
	/*public User findOne(int id) {
		// TODO Auto-generated method stub
		return userRepository.findOne(id);
	}*/
	
}
