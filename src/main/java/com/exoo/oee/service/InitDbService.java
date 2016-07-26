package com.exoo.oee.service;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exoo.oee.entity.Role;
import com.exoo.oee.entity.User;
import com.exoo.oee.entity.UserDetails;
import com.exoo.oee.repository.DailyReportRepository;
import com.exoo.oee.repository.RoleRepository;
import com.exoo.oee.repository.UserDetailsRepository;
import com.exoo.oee.repository.UserRepository;


@Transactional
@Service
public class InitDbService {

	
	@Autowired
	private RoleRepository roleRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private DailyReportRepository dailyReportRepository;
	
	@Autowired
	private UserDetailsRepository userDetailsRepository;
	
	@PostConstruct
	public void init(){
		
		/**Role adminRole = new Role();
		adminRole.setRoleName("ADMIN");
		roleRepository.save(adminRole);
		
		Role userRole = new Role();
		userRole.setRoleName("OPERATOR");
		roleRepository.save(userRole);
		
		Role analystRole = new Role();
		analystRole.setRoleName("ANALYST");
		roleRepository.save(analystRole);
		
		User masterUser = new User();
		masterUser.setUsername("exoo");
		masterUser.setPassword("klocek12");
		List<Role> rolesMaster = new ArrayList<Role>();
		rolesMaster.add(userRole);
		rolesMaster.add(adminRole);
		rolesMaster.add(analystRole);
		masterUser.setRoles(rolesMaster);
		userRepository.save(masterUser);
		
		UserDetails masterUserDet = new UserDetails();
		masterUserDet.setFirstName("Marcin");
		masterUserDet.setLastName("Piskor");
		masterUserDet.setJobTitle("System Administrator");
		masterUserDet.setUser(masterUser);
		userDetailsRepository.save(masterUserDet);
		
		User operatorUser1 = new User();
		operatorUser1.setUsername("operator1");
		operatorUser1.setPassword("operator1");
		List<Role> rolesOperator1 = new ArrayList<Role>();
		rolesOperator1.add(userRole);
		operatorUser1.setRoles(rolesOperator1);	
		userRepository.save(operatorUser1);
		
		UserDetails operatorUser1Det = new UserDetails();
		operatorUser1Det.setFirstName("Al");
		operatorUser1Det.setLastName("Pacino");
		operatorUser1Det.setJobTitle("Line operator");
		operatorUser1Det.setUser(operatorUser1);
		userDetailsRepository.save(operatorUser1Det);
		
		User operatorUser2 = new User();
		operatorUser2.setUsername("operator2");
		operatorUser2.setPassword("operator2");
		List<Role> rolesOperator2 = new ArrayList<Role>();
		rolesOperator2.add(userRole);
		operatorUser2.setRoles(rolesOperator2);
		userRepository.save(operatorUser2);
		
		UserDetails operatorUser2Det = new UserDetails();
		operatorUser2Det.setFirstName("Jackie");
		operatorUser2Det.setLastName("Chan");
		operatorUser2Det.setJobTitle("Line operator");
		operatorUser2Det.setUser(operatorUser2);
		userDetailsRepository.save(operatorUser2Det);
		
		User operatorUser3 = new User();
		operatorUser3.setUsername("operator3");
		operatorUser3.setPassword("operator3");
		List<Role> rolesOperator3 = new ArrayList<Role>();
		rolesOperator3.add(userRole);
		operatorUser3.setRoles(rolesOperator3);
		userRepository.save(operatorUser3);
		
		UserDetails operatorUser3Det = new UserDetails();
		operatorUser3Det.setFirstName("Jack");
		operatorUser3Det.setLastName("Nicholson");
		operatorUser3Det.setJobTitle("Line operator");
		operatorUser3Det.setUser(operatorUser3);
		userDetailsRepository.save(operatorUser3Det);
		
		User analystUser1 = new User();
		analystUser1.setUsername("analyst1");
		analystUser1.setPassword("analyst1");
		List<Role> rolesAnalyst1 = new ArrayList<Role>();
		rolesAnalyst1.add(analystRole);
		analystUser1.setRoles(rolesAnalyst1);
		userRepository.save(analystUser1);
		
		UserDetails analystUser1Det = new UserDetails();
		analystUser1Det.setFirstName("Angelina");
		analystUser1Det.setLastName("Jolie");
		analystUser1Det.setJobTitle("Data analysis specialist");
		analystUser1Det.setUser(analystUser1);
		userDetailsRepository.save(analystUser1Det);**/
		
		
		
	}
}
