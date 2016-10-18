package com.exoo.oee.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.exoo.oee.repository.DailyReportRepository;
import com.exoo.oee.repository.RoleRepository;
import com.exoo.oee.repository.UserDetailsRepository;
import com.exoo.oee.repository.UserRepository;
import com.exoo.oee.wrapper.UserRegistrationWrapper;
import com.exoo.oee.entity.DailyReport;
import com.exoo.oee.entity.Role;
import com.exoo.oee.entity.User;
import com.exoo.oee.entity.UserDetails;

@Service
@Transactional
public class UserService {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private DailyReportRepository dailyReportRepository;
	
	@Autowired
	private RoleRepository roleRepository;
	
	@Autowired UserDetailsRepository userDetailsRepository;
	
	
	public Page<User> findAll(int pageNumber){
		PageRequest request =
	            new PageRequest(pageNumber - 1, 10, Sort.Direction.DESC, "id");
		Page<User> page = userRepository.findAll(request);
		
		List<User> users = page.getContent();
		
		for(User user : users ){
			List<DailyReport> dailyReportList  = dailyReportRepository.findByReportCreatedBy(user);
			user.setDailyReports(dailyReportList);
		}
		
		return page ;
	}

	public User getOne(int id) {
		return userRepository.findOne(id);
	}

	/*@Transactional
	public User getOneWithReports(int id) {
		User user = getOne(id);
		List<DailyReport> reportsList = dailyReportRepository.findByUser(user, new PageRequest(0, 10, Direction.DESC, "dateOfReport"));
		user.setDailyReports(reportsList);
		return user;
	}*/


	// example for fetch=FetchType.LAZY
	/*public User findOne(int id) {
		// TODO Auto-generated method stub
		return userRepository.findOne(id);
	}*/

	public void save(UserRegistrationWrapper newUser) {
		User user = new User();
			user.setEnabled(true);
			user.setUsername(newUser.getUsername());
			BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
			user.setPassword(encoder.encode(newUser.getPassword()));
		
			List<Role> roles = new ArrayList<Role>();
				roles = roleRepository.findAll(newUser.getRoleId());
			
			user.setRoles(roles);
			
			userRepository.save(user);
			
			UserDetails userDetails = new UserDetails();
				userDetails.setFirstName(newUser.getFirstName());
				userDetails.setLastName(newUser.getLastName());
				userDetails.setJobTitle(newUser.getJobTitle());
				userDetails.setEmail(newUser.getEmail());
				userDetails.setUser(user);
			
				userDetailsRepository.save(userDetails);
			//user.setUserDetails(userDetails);
			
		
			System.out.println(user.toString());
		
		
		
	}

	public Object getOne(String name) {
		User user = userRepository.findByUsername(name);
		//System.out.println(user.getUsername());
		return user;
	}

	public void delete(Integer id) {
		userRepository.delete(id);
		
	}
	
	
	
}
